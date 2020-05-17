package pl.sda.javawwa22project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javawwa22project.repository.CategoryRepository;

@Service
public class CategoryService {
    private final static Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final CategoryRepository categoryRepository;

    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        logger.info("Created CategoryService object.");
    }
}
