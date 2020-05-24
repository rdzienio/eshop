package pl.sda.javawwa22project.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ItemDto> displayItemById(@PathVariable Long id) {
        logger.info("displayItemById with id: [{}]", id);
        var result = itemsService.findItemById(id)
                .map(itemConverter::fromItem)
                .orElse(null);

        if (result != null)
            return ResponseEntity.ok(result);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/item-save")
    public ItemDto saveItem(@RequestBody ItemDto itemToSave) {
        logger.info("saveItem(), received param: [{}]", itemToSave);

        var item = itemConverter.fromDto(itemToSave);
        return itemConverter.fromItem(itemsService.saveItem(item));
    }

}
