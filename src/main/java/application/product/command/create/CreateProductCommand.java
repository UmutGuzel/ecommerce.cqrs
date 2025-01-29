package application.product.command.create;


import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs3.domain.entity.Product;
import com.turkcell.turkcellcqrs3.persistance.product.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCommand implements Command<CreatedProductResponse> {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String image;
    private Date createdAt;
    private Date updatedAt;



    @Component
    @RequiredArgsConstructor
    private static class CreateProductCommandHandler
    implements Handler<CreateProductCommand, CreatedProductResponse> {

        private final ProductRepository productRepository;
        @Override
        public CreatedProductResponse handle(CreateProductCommand createProductCommand) {
            Product product=new Product();
            product.setName(createProductCommand.getName());
            product.setDescription(createProductCommand.getDescription());
            product.setPrice(createProductCommand.getPrice());
            product.setStock(createProductCommand.getStock());
            product.setImage(createProductCommand.getImage());
            product.setCreatedAt(createProductCommand.getCreatedAt());
            product.setUpdatedAt(createProductCommand.getUpdatedAt());
            productRepository.save(product);

            return new CreatedProductResponse(product.getId(), product.getName()
            , product.getDescription(), product.getPrice()
                    , product.getStock(), product.getImage(), product.getCreatedAt(), product.getUpdatedAt());
        }
    }

}
