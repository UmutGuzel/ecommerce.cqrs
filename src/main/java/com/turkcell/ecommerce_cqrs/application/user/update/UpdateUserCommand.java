package com.turkcell.ecommerce_cqrs.application.user.update;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs3.application.category.command.update.UpdatedCategoryCommand;
import com.turkcell.turkcellcqrs3.domain.entity.User;
import com.turkcell.turkcellcqrs3.persistance.user.UserRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserCommand implements Command<UpdatedUserResponse> {

    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @Component
    @RequiredArgsConstructor
    public static class UpdateUserCommandHandler implements Handler<UpdateUserCommand,UpdatedUserResponse>{

        private final UserRepository userRepository;

        @Override
        public UpdatedUserResponse handle(UpdateUserCommand updateUserCommand) {
            User user=userRepository
                    .findById(updateUserCommand.getId()).orElseThrow(()->new RuntimeException("User not found"));
            user.setName(updateUserCommand.getName());
            user.setSurname(updateUserCommand.getSurname());
            user.setEmail(updateUserCommand.getEmail());
            user.setPassword(updateUserCommand.getPassword());
            userRepository.save(user);
            return new UpdatedUserResponse(user.getId(),user.getName(),user.getSurname(),user.getEmail(),user.getPassword());
        }
    }

}
