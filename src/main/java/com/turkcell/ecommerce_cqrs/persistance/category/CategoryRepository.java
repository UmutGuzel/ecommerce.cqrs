package com.turkcell.ecommerce_cqrs.persistance.category;

import com.turkcell.ecommerce_cqrs.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
