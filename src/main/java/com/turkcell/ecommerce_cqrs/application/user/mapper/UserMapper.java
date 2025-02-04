package com.turkcell.ecommerce_cqrs.application.user.mapper;

import com.turkcell.ecommerce_cqrs.application.role.service.RoleService;
import com.turkcell.ecommerce_cqrs.application.user.command.create.CreateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.create.CreatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.update_user_role.UpdateUserRoleCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update_user_role.UpdateUserRoleResponse;
import com.turkcell.ecommerce_cqrs.application.user.query.getlist.GetListUserDto;
import com.turkcell.ecommerce_cqrs.domain.entity.Role;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected RoleService roleService;

//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract CreatedUserResponse toCreatedUserResponse(User user);
    public abstract User toEntity(CreateUserCommand createUserCommand);
    public abstract void updateEntity(@MappingTarget User user, UpdateUserCommand updateUserCommand);
    public abstract UpdatedUserResponse toUpdatedUserResponse(User user);
    public abstract List<GetListUserDto> toListUserDto(List<User> users);
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "roles", expression = "java(getRoles(updateUserRoleCommand.getRoleNames()))")
    public abstract void updateEntity(@MappingTarget User user, UpdateUserRoleCommand updateUserRoleCommand);
    public abstract UpdateUserRoleResponse toUpdateUserRoleResponse(User user);

    protected List<Role> getRoles(List<String> roleNames) {
        return roleService.getRolesByNames(roleNames);
    }
}
