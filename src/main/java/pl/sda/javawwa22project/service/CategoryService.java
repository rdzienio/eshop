package pl.sda.javawwa22project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javawwa22project.entity.Category;
import pl.sda.javawwa22project.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final static Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final CategoryRepository categoryRepository;

    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        logger.info("Created CategoryService object.");
    }

    public List<Category> findAllCategories(){
        logger.info("findAllCategories()");
        var categoryList = categoryRepository.findAll();
        logger.info("Number of found categories: [{}]", categoryList.size());
        logger.info("Found categories: [{}]", categoryList);
        return categoryList;
    }

    public Optional<Category> findById(final Long id){
        logger.info("Finding category with id: [{}]", id);
        var category = categoryRepository.findById(id);
        logger.info("Category found: [{}]", category.orElse(null));
        return category;
    }
}
