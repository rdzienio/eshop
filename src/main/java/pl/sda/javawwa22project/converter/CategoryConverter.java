package pl.sda.javawwa22project.converter;

import org.springframework.stereotype.Component;
import pl.sda.javawwa22project.dto.CategoryDto;
import pl.sda.javawwa22project.entity.Category;

@Component
public class CategoryConverter {

    public CategoryDto fromCategory(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .created(category.getCreated())
                .updated(category.getUpdated())
                .build();
    }
}
