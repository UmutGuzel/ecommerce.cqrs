package application.user.delete;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs3.application.category.command.delete.DeletedCategoryResponse;
import com.turkcell.turkcellcqrs3.domain.entity.User;
import com.turkcell.turkcellcqrs3.persistance.user.UserRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeleteUserCommand implements Command<DeletedUserResponse> {
    private UUID id;

    @Component
    @RequiredArgsConstructor
    public static class DeleteUserCommandHandler
    implements Handler<DeleteUserCommand, DeletedUserResponse> {

        private final UserRepository userRepository;
        @Override
        public DeletedUserResponse handle(DeleteUserCommand deleteUserCommand) {
            User user = userRepository.findById(deleteUserCommand.getId()).orElseThrow(()->new RuntimeException("User not found"));
            userRepository.delete(user);

            return new DeletedUserResponse(user.getId(), "Category deleted successfully.");
        }
    }


}
