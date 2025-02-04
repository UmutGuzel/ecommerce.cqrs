package com.turkcell.ecommerce_cqrs.application.role.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.application.role.mapper.RoleMapper;
import com.turkcell.ecommerce_cqrs.domain.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleCommand implements Command<CreateRoleResponse> {
    @NotBlank
    private String name;

    @Component
    static class CreateRoleCommandHandler implements Command.Handler<CreateRoleCommand, CreateRoleResponse> {
        @Override
        public CreateRoleResponse handle(CreateRoleCommand createRoleCommand) {
            Role role = RoleMapper.INSTANCE.toEntity(createRoleCommand);

            return new CreateRoleResponse(createRoleCommand.getName());
        }
    }
}
