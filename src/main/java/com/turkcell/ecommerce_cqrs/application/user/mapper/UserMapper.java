package com.turkcell.ecommerce_cqrs.application.user.mapper;

import com.turkcell.ecommerce_cqrs.application.user.command.create.CreateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.create.CreatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.delete.DeleteUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdatedUserResponse;
import com.turkcell.ecommerce_cqrs.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreatedUserResponse toCreatedUserResponse(User user);
    User toEntity(CreateUserCommand createUserCommand);
    void updateEntity(@MappingTarget User user, UpdateUserCommand updateUserCommand);
    UpdatedUserResponse toUpdatedUserResponse(User user);
}
