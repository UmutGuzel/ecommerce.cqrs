package com.turkcell.ecommerce_cqrs.application.user.command.login;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.core.jwt.JwtService;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCommand implements Command<LoginCommandResponse> {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Component
    @RequiredArgsConstructor
    public static class LoginCommandHandler implements Command.Handler<LoginCommand, LoginCommandResponse> {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;

        @Override
        public LoginCommandResponse handle(LoginCommand loginCommand) {
            User user = userRepository.findByEmail(loginCommand.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

            if(!passwordEncoder.matches(loginCommand.getPassword(), user.getPassword())){
                throw new RuntimeException("Password is incorrect");
            }
            Map<String, Object> roles = Map.of("roles", user.getRoles().stream().map(role -> role.getName()).toList());

            return new LoginCommandResponse(jwtService.generateToken(loginCommand.getEmail(), roles));
        }
    }
}
