package pl.sda.javawwa22project.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.sda.javawwa22project.converter.ItemConverter;
import pl.sda.javawwa22project.dto.ItemDto;
import pl.sda.javawwa22project.service.ItemsService;

@RestController
@RequestMapping("/rest")
public class ItemRestController {

    private final ItemsService itemsService;
    private final ItemConverter itemConverter;

    private static final Logger logger = LoggerFactory.getLogger(ItemRestController.class);

    public ItemRestController(final ItemsService itemsService, final ItemConverter itemConverter) {
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

    @PostMapping("/item-save")
    public ItemDto saveItem(ItemDto itemToSave) {
        logger.info("saveItem(), received param: [{}]", itemToSave);

        var item = itemConverter.fromDto(itemToSave);
        return itemConverter.fromItem(itemsService.saveItem(item));
    }

}
