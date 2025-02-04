package com.turkcell.ecommerce_cqrs.application.user.command.update_user_role;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.application.role.service.RoleService;
import com.turkcell.ecommerce_cqrs.application.user.mapper.UserMapper;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRoleCommand implements Command<UpdateUserRoleResponse> {
    private String email;
    private List<String> roles;


    @Component
    @RequiredArgsConstructor
    public static class  UpdateUserRoleCommandHandler implements Command.Handler<UpdateUserRoleCommand, UpdateUserRoleResponse> {
        private final UserRepository userRepository;
        private final UserMapper userMapper;


        @Override
        public UpdateUserRoleResponse handle(UpdateUserRoleCommand command) {
            User user = userRepository.findByEmail(command.getEmail()).orElseThrow( () -> new RuntimeException("Kullanici bulunamadi"));
            userMapper.updateEntity(user, command);
            return userMapper.toUpdateUserRoleResponse(user);
        }
    }
}
