package com.turkcell.ecommerce_cqrs.application.category.command.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedCategoryResponse {

    private UUID id;
    private String  name;
}
