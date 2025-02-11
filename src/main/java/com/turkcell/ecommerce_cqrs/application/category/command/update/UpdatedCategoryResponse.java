package com.turkcell.ecommerce_cqrs.application.category.command.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCategoryResponse {

    private UUID id;
    private String name;
}
