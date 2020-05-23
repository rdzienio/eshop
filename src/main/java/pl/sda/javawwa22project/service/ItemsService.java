package pl.sda.javawwa22project.service;

//import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javawwa22project.entity.Item;
import pl.sda.javawwa22project.respository.ItemsRepository;

import java.util.List;
import java.util.Optional;

//@Slf4j
// 3). create service and add required operations
@Service
public class ItemsService {

  private static final Logger logger = LoggerFactory.getLogger(ItemsService.class);
  private final ItemsRepository itemsRepository;

  public ItemsService(final ItemsRepository itemsRepository) {
    this.itemsRepository = itemsRepository;
//    log.
    logger.debug("object ItemsService created - debug level");
    logger.info("object ItemsService created - info level");
    // trace
    // debug
    // info
    // warn
    // error
  }

  public List<Item> findAllItems() {
   var allItems = itemsRepository.findAll();

   logger.debug("items from repository: {}", allItems); // []
   logger.info("number of found items: [{}]", allItems.size());
   return allItems;
  }

  // find item by id...
  public Optional<Item> findItemById(Long id) {
    logger.info("findItemById() with id: [{}]", id);
    var foundItem = itemsRepository.findById(id);

    logger.info("found item: [{}]", foundItem.orElse(null));
    return foundItem;
  }

  public Item saveItem(Item item) {
    logger.info("saving item: [{}]", item);
    var savedItem = itemsRepository.save(item);
    logger.info("after saving: [{}]", savedItem);

    return savedItem;
  }
}
