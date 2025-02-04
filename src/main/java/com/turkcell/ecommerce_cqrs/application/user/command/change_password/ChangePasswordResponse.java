package com.turkcell.ecommerce_cqrs.application.user.command.change_password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordResponse {
    private boolean isChanged;
}
