package com.turkcell.ecommerce_cqrs.application.product.command.delete;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.entity.Product;
import com.turkcell.ecommerce_cqrs.persistance.product.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DeleteProductCommand implements Command<DeletedProductResponse> {
    private UUID id;
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class DeleteProductCommandHandler
    implements Handler<DeleteProductCommand, DeletedProductResponse> {
        private final ProductRepository productRepository;

        @Override
        public DeletedProductResponse handle(DeleteProductCommand deleteProductCommand) {
            Product product = productRepository.findById(deleteProductCommand.getId()).orElseThrow(()->new RuntimeException("Product not found"));
            productRepository.delete(product);

            return new DeletedProductResponse(product.getId(),"Product deleted successfully");
        }
    }


}
