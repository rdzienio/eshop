package pl.sda.javawwa22project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    private String itemName;
    private String description;
    private String category;
    private BigDecimal price;
    private int quantity;
    private String picture;

}
