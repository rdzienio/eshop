package pl.sda.javawwa22project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class CategoryDto {

    private Long id;

    private String categoryName;

    private LocalDate created;

    private LocalDate updated;
}
