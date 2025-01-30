package com.turkcell.ecommerce_cqrs.application.user.mapper;

import com.turkcell.ecommerce_cqrs.application.user.command.create.CreateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.create.CreatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.query.getlist.GetListUserDto;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreatedUserResponse toCreatedUserResponse(User user);
    User toEntity(CreateUserCommand createUserCommand);
    void updateEntity(@MappingTarget User user, UpdateUserCommand updateUserCommand);
    UpdatedUserResponse toUpdatedUserResponse(User user);
    List<GetListUserDto> toListUserDto(List<User> users);
}
