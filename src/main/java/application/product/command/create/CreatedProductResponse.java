package application.product.command.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CreatedProductResponse {


        private UUID id;
        private String  name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String image;
    private Date createdAt;
    private Date updatedAt;

}


