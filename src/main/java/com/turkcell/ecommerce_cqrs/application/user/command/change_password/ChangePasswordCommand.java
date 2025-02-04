package com.turkcell.ecommerce_cqrs.application.user.command.change_password;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordCommand implements Command<ChangePasswordResponse> {
    @Email(message = "Eposta uygun formatta değil", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    @NotBlank(message = "Eposta alanı boş bırakılamaz.")
    private String email;
    @Length(min=8, message = "Eski şifre en az 8 karakter olmalıdır.")
    @NotBlank(message = "Eski şifre alanı boş bırakılamaz.")
    private String oldPassword;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="Şifre en az bir büyük harf, bir küçük harf ve bir rakam içermelidir.")
    @Length(min=8, message = "Yeni şifre en az 8 karakter olmalıdır.")
    @NotBlank(message = "Yeni şifre alanı boş bırakılamaz.")
    private String newPassword;

    @Component
    @RequiredArgsConstructor
    public static class ChangePasswordCommandHandler implements Handler<ChangePasswordCommand, ChangePasswordResponse>{
        UserRepository userRepository;
        PasswordEncoder passwordEncoder;
        @Override
        public ChangePasswordResponse handle(ChangePasswordCommand changePasswordCommand) {
            User user = userRepository.findByEmail(changePasswordCommand.getEmail()).orElseThrow(()->new RuntimeException("Kullanıcı bulunamadı"));
            if(!passwordEncoder.matches(changePasswordCommand.getNewPassword(), user.getPassword()))
                throw new RuntimeException("Şifre hatalı");
            user.setPassword(passwordEncoder.encode(changePasswordCommand.getNewPassword()));
            userRepository.save(user);

            return new ChangePasswordResponse(true);
        }
    }
}
