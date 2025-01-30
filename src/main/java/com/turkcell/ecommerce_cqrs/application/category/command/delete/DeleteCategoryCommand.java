package com.turkcell.ecommerce_cqrs.application.category.command.delete;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.entity.Category;
import com.turkcell.ecommerce_cqrs.persistance.category.CategoryRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCategoryCommand implements Command<DeletedCategoryResponse> {
    private UUID id;


    @Component
    @RequiredArgsConstructor
    public static class DeleteCategoryCommandHandler
    implements Handler<DeleteCategoryCommand, DeletedCategoryResponse> {

        private final CategoryRepository categoryRepository;
        @Override
        public DeletedCategoryResponse handle(DeleteCategoryCommand deleteCategoryCommand) {
            Category category=categoryRepository.findById(deleteCategoryCommand.getId()).orElseThrow(()->new RuntimeException("Category not found."));
            categoryRepository.delete(category);

            return new DeletedCategoryResponse(category.getId(), "Category deleted successfully.");

        }
    }
}
