package pl.sda.javawwa22project.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javawwa22project.repository.ItemRepository;

//@Slf4j
@Service
public class ItemService {

    private final static Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    public ItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        logger.info("Created ItemService object.");
        logger.debug("object ItemsService created - debug level");
    }
}
