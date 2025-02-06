package com.turkcell.ecommerce_cqrs.persistance.category;

import com.turkcell.ecommerce_cqrs.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findById(UUID id);

}
