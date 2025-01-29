package application.product.command.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedProductResponse {
    private UUID id;
    private String  name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String image;
    private Date createdAt;
    private Date updatedAt;
}
