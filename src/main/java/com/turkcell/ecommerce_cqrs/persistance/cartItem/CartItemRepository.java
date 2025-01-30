package com.turkcell.ecommerce_cqrs.persistance.cartItem;

import com.turkcell.ecommerce_cqrs.entity.Cart;
import com.turkcell.ecommerce_cqrs.entity.CartItem;
import com.turkcell.ecommerce_cqrs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    CartItem findByCartAndProduct(Cart cart, Product product);

}
