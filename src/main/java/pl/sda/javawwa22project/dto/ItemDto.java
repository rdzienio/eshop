package pl.sda.javawwa22project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@Builder
public class ItemDto {

    private Long id;
    private String itemName;
    private String description;
    private CategoryDto category;
    private BigDecimal price;
    private int quantity;
    private String picture;
}
