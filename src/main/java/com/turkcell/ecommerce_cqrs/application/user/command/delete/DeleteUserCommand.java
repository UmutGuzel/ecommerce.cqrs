package com.turkcell.ecommerce_cqrs.application.user.command.delete;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthorizedRequest;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeleteUserCommand implements Command<DeletedUserResponse>, AuthenticatedRequest, AuthorizedRequest {
    private UUID id;

    @Override
    public List<String> getRequiredRoles() {
        return List.of("admin");
    }

    @Component
    @RequiredArgsConstructor
    public static class DeleteUserCommandHandler
    implements Handler<DeleteUserCommand, DeletedUserResponse> {

        private final UserRepository userRepository;
        @Override
        public DeletedUserResponse handle(DeleteUserCommand deleteUserCommand) {
            User user = userRepository.findById(deleteUserCommand.getId()).orElseThrow(()->new RuntimeException("User not found"));
            userRepository.delete(user);

            return new DeletedUserResponse(true);
        }
    }


}
