package com.turkcell.ecommerce_cqrs.application.role.service;

import com.turkcell.ecommerce_cqrs.domain.entity.Role;
import com.turkcell.ecommerce_cqrs.persistance.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getRolesByNames(List<String> names) {
        return roleRepository.findAllByNameIn(names);
    }
}
