package com.turkcell.ecommerce_cqrs.application.category.service;



//servicesleriniz conrollerlar ile çalışmadığı iin entity ile rahatça çalışabiliriz


import com.turkcell.ecommerce_cqrs.domain.entity.Category;
import com.turkcell.ecommerce_cqrs.persistance.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    //burası service olduğu için orelsetrow çok tercih edilmez ıd ye göre ya vardır ya yoktur
    @Override
    public Category findCategoryById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category; //save ettim son hali budur
    }

    @Override
    public UUID delete(UUID id) {
        categoryRepository.deleteById(id);
        return id;
    }
}
