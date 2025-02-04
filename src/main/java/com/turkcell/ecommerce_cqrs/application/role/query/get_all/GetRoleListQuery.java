package com.turkcell.ecommerce_cqrs.application.role.query.get_all;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.application.role.mapper.RoleMapper;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthorizedRequest;
import com.turkcell.ecommerce_cqrs.domain.entity.Role;
import com.turkcell.ecommerce_cqrs.persistance.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

public class GetRoleListQuery implements Command<List<RoleDto>>, AuthenticatedRequest, AuthorizedRequest {

    @Override
    public List<String> getRequiredRoles() {
        return List.of("admin");
    }

    @RequiredArgsConstructor
    @Component
    public static class GetRoleListQueryHandler implements Command.Handler<GetRoleListQuery, List<RoleDto>> {
       private final RoleRepository roleRepository;
       private final RoleMapper roleMapper;
        @Override
        public List<RoleDto> handle(GetRoleListQuery getRoleListQuery) {
            List<Role> roles = roleRepository.findAll();
            return roleMapper.toDtoList(roles);
        }
    }
}
