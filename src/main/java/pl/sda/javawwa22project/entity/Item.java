package pl.sda.javawwa22project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SHOP_ITEMS")
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String itemName;
    private String description;
    private String category;
    private BigDecimal price;
    private int quantity;
    private String picture;

}
