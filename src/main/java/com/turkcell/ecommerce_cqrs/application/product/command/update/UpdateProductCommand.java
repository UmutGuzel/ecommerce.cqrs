package com.turkcell.ecommerce_cqrs.application.product.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs3.domain.entity.Product;
import com.turkcell.turkcellcqrs3.persistance.product.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductCommand implements Command<UpdatedProductResponse> {

    private UUID id;
    private String  name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String image;
    private Date createdAt;
    private Date updatedAt;

    @Component
    @RequiredArgsConstructor
    public static class UpdatedProductCommandHandler
    implements Handler<UpdateProductCommand, UpdatedProductResponse> {

        private final ProductRepository productRepository;
        @Override
        public UpdatedProductResponse handle(UpdateProductCommand updateProductCommand) {
            Product product = productRepository.findById(updateProductCommand.getId()).orElseThrow(()->new RuntimeException("Product not found"));
            product.setName(updateProductCommand.getName());
            product.setDescription(updateProductCommand.getDescription());
            product.setPrice(updateProductCommand.getPrice());
            product.setStock(updateProductCommand.getStock());
            product.setImage(updateProductCommand.getImage());
            product.setCreatedAt(updateProductCommand.getCreatedAt());
            product.setUpdatedAt(updateProductCommand.getUpdatedAt());
            productRepository.save(product);
            return new UpdatedProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getStock(),product.getImage(),product.getCreatedAt(),product.getUpdatedAt());
        }
    }
}
