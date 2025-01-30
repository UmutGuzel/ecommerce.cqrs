package com.turkcell.ecommerce_cqrs.application.user.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.application.user.mapper.UserMapper;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserCommand implements Command<CreatedUserResponse> {



    @NotBlank(message = "İsim alanı boş bırakılamaz.")
    private String name;

    @NotBlank(message = "Soyisim alanı boş bırakılamaz.")
    private String surname;

    @Email(message = "Eposta uygun formatta değil", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    @NotBlank(message = "Eposta alanı boş bırakılamaz.")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="Şifre en az bir büyük harf, bir küçük harf ve bir rakam içermelidir.")
    @Length(min=8)
    @NotBlank
    private String password;


    @Component
    @RequiredArgsConstructor
    public static class CreateUserCommandHandler
            implements Handler<CreateUserCommand, CreatedUserResponse> {
        private final UserRepository userRepository;

        @Override
        public CreatedUserResponse handle(CreateUserCommand createUserCommand) {
            UserMapper userMapper = UserMapper.INSTANCE;
            User user = userMapper.toEntity(createUserCommand);
            userRepository.save(user);

            return userMapper.toCreatedUserResponse(user);
        }
    }



}
