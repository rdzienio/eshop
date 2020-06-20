package pl.sda.javawwa22project.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_ITEMS")

//TODO
// 1). define entity
//  - id
// - no args constructor
public class Item {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    private Long id;
    private String itemName;
    private String description;
    private String stringCategory;
    @ManyToOne
    private Category category;
    private BigDecimal price;
    private int quantity;
    private String picture;
//    private int any; // have fun:) look out!!!
}
