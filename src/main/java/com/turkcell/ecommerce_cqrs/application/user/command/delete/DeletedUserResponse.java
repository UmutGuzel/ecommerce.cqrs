package com.turkcell.ecommerce_cqrs.application.user.command.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeletedUserResponse {
    private boolean isSuccessful;


}
