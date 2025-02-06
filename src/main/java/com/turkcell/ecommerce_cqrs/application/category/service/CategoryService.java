package com.turkcell.ecommerce_cqrs.application.category.service;


import com.turkcell.ecommerce_cqrs.domain.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category findCategoryById(UUID id);
    List<Category> findAll();
    Category save(Category category);
    UUID delete(UUID id);
}
