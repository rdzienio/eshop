package pl.sda.javawwa22project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.javawwa22project.dto.CategoryDto;
import pl.sda.javawwa22project.entity.Category;

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
                .items(category.getItems().stream().map(itemConverter::fromEntity).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Category fromDTO(final CategoryDto dto) {
        return null;
    }
}
