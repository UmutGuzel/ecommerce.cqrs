package com.turkcell.ecommerce_cqrs.application.role.service;

import com.turkcell.ecommerce_cqrs.domain.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesByNames(List<String> names);
}
