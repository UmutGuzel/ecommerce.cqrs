package com.turkcell.ecommerce_cqrs.application.user.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.application.user.mapper.UserMapper;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserCommand implements Command<UpdatedUserResponse>, AuthenticatedRequest {

    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @Component
    @RequiredArgsConstructor
    public static class UpdateUserCommandHandler implements Handler<UpdateUserCommand,UpdatedUserResponse>{
        private final UserMapper userMapper;
        private final UserRepository userRepository;

        @Override
        public UpdatedUserResponse handle(UpdateUserCommand updateUserCommand) {

            User user=userRepository
                    .findById(updateUserCommand.getId()).orElseThrow(()->new RuntimeException("User not found"));

            userMapper.updateEntity(user,updateUserCommand);

            userRepository.save(user);
            return userMapper.toUpdatedUserResponse(user);
        }
    }

}
