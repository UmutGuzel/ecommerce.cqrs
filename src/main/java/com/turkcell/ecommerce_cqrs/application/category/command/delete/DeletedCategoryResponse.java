package com.turkcell.ecommerce_cqrs.application.category.command.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeletedCategoryResponse {

    private UUID id;
    private String name;
}
