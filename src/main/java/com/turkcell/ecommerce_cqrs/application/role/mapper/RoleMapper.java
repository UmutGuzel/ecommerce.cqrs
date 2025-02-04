package com.turkcell.ecommerce_cqrs.application.role.mapper;

import com.turkcell.ecommerce_cqrs.application.role.command.create.CreateRoleCommand;
import com.turkcell.ecommerce_cqrs.application.role.command.create.CreateRoleResponse;
import com.turkcell.ecommerce_cqrs.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toEntity(CreateRoleCommand createRoleCommand);
    CreateRoleResponse toResponse(Role role);

}
