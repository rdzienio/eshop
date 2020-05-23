package pl.sda.javawwa22project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javawwa22project.entity.Item;
import pl.sda.javawwa22project.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final static Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    public ItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        logger.info("Created ItemService object.");
    }

    public List<Item> findAllItems(){
        var allItems = itemRepository.findAll();
        logger.info("Number of found items: [{}]", allItems.size());
        logger.debug("Found items: {}", allItems);
        return allItems;
    }

    public Optional<Item> findById(final Long itemId){
        logger.info("Finding item with id: [{}]", itemId);
        var foundItem = itemRepository.findById(itemId);
        logger.info("Found item: [{}]", foundItem.orElse(null));
        return foundItem;
    }

    public Item saveItem(Item itemToSave){
        logger.info("saveItem() from ItemService with param: [{}]", itemToSave);
        var itemSaved = itemRepository.save(itemToSave);
        logger.info("Saved item: [{}]", itemSaved);
        return itemSaved;
    }
}
