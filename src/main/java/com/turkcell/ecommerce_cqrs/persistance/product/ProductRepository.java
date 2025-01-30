package com.turkcell.ecommerce_cqrs.persistance.product;

import com.turkcell.ecommerce_cqrs.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
