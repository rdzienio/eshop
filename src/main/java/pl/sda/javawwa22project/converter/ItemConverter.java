package pl.sda.javawwa22project.converter;

import org.springframework.stereotype.Component;
import pl.sda.javawwa22project.dto.ItemDto;
import pl.sda.javawwa22project.entity.Item;

@Component
public class ItemConverter {

  public ItemDto fromItem(Item item) {
    return ItemDto.builder()
        .id(item.getId())
        .itemName(item.getItemName())
        .description(item.getDescription())
        .category(item.getCategory())
        .price(item.getPrice())
        .quantity(item.getQuantity())
        .picture(item.getPicture())
        .build();
  }

  public Item fromDto(ItemDto itemDto) {
    return new Item(
        itemDto.getId(),
        itemDto.getItemName(),
        itemDto.getDescription(),
        itemDto.getCategory(),
        itemDto.getPrice(),
        itemDto.getQuantity(),
        itemDto.getPicture()
    );
  }
}
