package pl.sda.javawwa22project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.javawwa22project.dto.CategoryDto;
import pl.sda.javawwa22project.dto.ItemDto;
import pl.sda.javawwa22project.entity.Category;
import pl.sda.javawwa22project.entity.Item;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter implements Converter<Category, CategoryDto> {

    private ItemConverter itemConverter;

    @Autowired
    public void setCategoryConverter(ItemConverter itemConverter) {
        this.itemConverter = itemConverter;
    }

    @Override
    public CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .items(getAllItemsConverted(category))
                .build();
    }

    private List<ItemDto> getAllItemsConverted(final Category category) {
        return category.getItems().stream().map(itemConverter::fromEntity).collect(Collectors.toList());
    }

    private List<Item> getAllItemsConvertedFromDto(final CategoryDto dto) {
        return dto.getItems().stream().map(itemConverter::fromDto).collect(Collectors.toList());
    }

    @Override
    public Category fromDTO(final CategoryDto dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .items(getAllItemsConvertedFromDto(dto))
                .build();
    }
}
