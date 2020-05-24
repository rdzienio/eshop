package pl.sda.javawwa22project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javawwa22project.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
