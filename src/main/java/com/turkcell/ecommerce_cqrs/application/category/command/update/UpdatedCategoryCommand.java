package com.turkcell.ecommerce_cqrs.application.category.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.entity.Category;
import com.turkcell.ecommerce_cqrs.persistance.category.CategoryRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedCategoryCommand implements Command<UpdatedCategoryResponse> {
    private UUID id;
    private String name;


    @Component
    @RequiredArgsConstructor
    private static class UpdateCategoryCommandHandler implements Handler<UpdatedCategoryCommand, UpdatedCategoryResponse> {

        private final CategoryRepository categoryRepository;
        @Override
        public UpdatedCategoryResponse handle(UpdatedCategoryCommand updateCategoryCommand) {
            Category category=categoryRepository.findById(updateCategoryCommand.getId()).orElseThrow(()->new RuntimeException("Category not found"));
            category.setName(updateCategoryCommand.getName());

            categoryRepository.save(category);
            return new UpdatedCategoryResponse(category.getId(),category.getName());
        }
    }
}
