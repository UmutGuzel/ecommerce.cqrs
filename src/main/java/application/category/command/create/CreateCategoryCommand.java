package application.category.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs3.domain.entity.Category;
import com.turkcell.turkcellcqrs3.persistance.category.CategoryRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateCategoryCommand implements Command<CreatedCategoryResponse> {

    @NotBlank(message = "Kategori adı boş olamaz.")
    @Size(max=100,message = "Kategori adı en fazla 100 karakter olmalıdır.")
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class CreateCategoryCommandHandler
    implements Handler<CreateCategoryCommand, CreatedCategoryResponse> {

        private final CategoryRepository categoryRepository;
        @Override
        public CreatedCategoryResponse handle(CreateCategoryCommand createCategoryCommand) {
            Category category = new Category();
            category.setName(createCategoryCommand.getName());
            categoryRepository.save(category);

            return new CreatedCategoryResponse(category.getId(),category.getName());
        }
    }


}
