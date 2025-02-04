package com.turkcell.ecommerce_cqrs.application.role.rule;

import com.turkcell.ecommerce_cqrs.persistance.role.RoleRepository;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Data
public class RoleBusinessRule {
   private final RoleRepository roleRepository;
    public void ShouldNotBeSameRole(String role) {
        roleRepository.findByName(role).ifPresent(r -> {
            throw new IllegalArgumentException("Rol zaten mevcut");
        });
    }
}
