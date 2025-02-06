package com.turkcell.ecommerce_cqrs.application.category.rules;



import com.turkcell.ecommerce_cqrs.domain.entity.Category;
import com.turkcell.ecommerce_cqrs.persistance.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;

    public void categoryShouldExistWithGivenById(UUID id){
        categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category does not exist"));
    }

    public void categoryShouldNotBeNull(Category category){
        if(category == null){
            throw new RuntimeException("Category should not be null");
        }

    }
}
