package application.user.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs3.application.category.command.create.CreateCategoryCommand;
import com.turkcell.turkcellcqrs3.application.category.command.create.CreatedCategoryResponse;

import com.turkcell.turkcellcqrs3.domain.entity.User;
import com.turkcell.turkcellcqrs3.persistance.user.UserRepository;
import jakarta.persistence.Id;
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
            User user = new User();




            user.setName(createUserCommand.getName());
            user.setSurname(createUserCommand.getSurname());
            user.setEmail(createUserCommand.getEmail());
            user.setPassword(createUserCommand.getPassword());
            userRepository.save(user);

            return new CreatedUserResponse( user.getName(), user.getSurname(), user.getEmail() ,user.getPassword());
        }
    }



}
