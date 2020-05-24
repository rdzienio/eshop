package pl.sda.javawwa22project.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javawwa22project.converter.ItemConverter;
import pl.sda.javawwa22project.dto.ItemDto;
import pl.sda.javawwa22project.service.ItemsService;

@RestController
@RequestMapping("/rest")
public class ItemRestController {

  private static final Logger logger = LoggerFactory.getLogger(ItemRestController.class);
  private static final String ONE_ITEM_KEY = "itemsToShow";

  private final ItemsService itemsService;
  private final ItemConverter itemConverter;

  public ItemRestController(final ItemsService itemsService,
                            final ItemConverter itemConverter) {
    this.itemsService = itemsService;
    this.itemConverter = itemConverter;
  }

  @GetMapping("/items/{id}")
  public ItemDto displayItemById(@PathVariable Long id) {
    logger.info("displayItemById with id: [{}]", id);
    return itemsService.findItemById(id)
        .map(itemConverter::fromItem)
        .orElse(ItemDto.builder().build());
  }
}
