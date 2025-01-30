package com.turkcell.ecommerce_cqrs.persistance.user;

import com.turkcell.ecommerce_cqrs.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
