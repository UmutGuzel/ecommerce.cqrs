package com.turkcell.ecommerce_cqrs.persistance.cart;

import com.turkcell.ecommerce_cqrs.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    Optional<Cart> findByUserId(UUID userId);

}
