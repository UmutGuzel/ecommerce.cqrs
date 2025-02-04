package com.turkcell.ecommerce_cqrs.application.role.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleResponse {
     private String name;
}
