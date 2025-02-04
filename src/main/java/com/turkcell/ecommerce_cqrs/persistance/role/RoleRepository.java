package com.turkcell.ecommerce_cqrs.persistance.role;

import com.turkcell.ecommerce_cqrs.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);
    List<Role> findAllByNameIn(List<String> names);
}
