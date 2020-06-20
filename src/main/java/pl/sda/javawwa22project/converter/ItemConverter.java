package pl.sda.javawwa22project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.javawwa22project.dto.ItemDto;
import pl.sda.javawwa22project.entity.Item;

@Component
public class ItemConverter implements Converter<Item, ItemDto>{
    private ItemConverter itemConverter;

    @Autowired
    public void setItemConverter(ItemConverter itemConverter) {
        this.itemConverter = itemConverter;
    }

    @Override
    public ItemDto fromEntity(final Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .description(item.getDescription())
                .category(item.)
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .picture(item.getPicture())
                .build();
    }

    @Override
    public Item fromDto(final ItemDto itemDto) {
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
