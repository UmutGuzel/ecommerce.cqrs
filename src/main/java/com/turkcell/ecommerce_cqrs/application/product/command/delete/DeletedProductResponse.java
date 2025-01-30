package com.turkcell.ecommerce_cqrs.application.product.command.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeletedProductResponse {
    private UUID id;
    private String name;
}
