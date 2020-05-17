package pl.sda.javawwa22project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.javawwa22project.converter.ItemConverter;
import pl.sda.javawwa22project.dto.ItemDto;
import pl.sda.javawwa22project.service.ItemService;

import javax.validation.Valid;

import java.util.stream.Collectors;

// 4). define endpoint in controller
@Controller
public class ItemController {

    public static String ONE_ITEM_KEY = "itemToShow";
    public static String MANY_ITEMS_KEY = "allItems";
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final ItemConverter itemConverter;

    public ItemController(final ItemService itemService, final ItemConverter itemConverter) {
        this.itemService = itemService;
        this.itemConverter = itemConverter;
    }

    @GetMapping("/items/{id}")
    String getItemById(@PathVariable Long id, Model model) {
        LOGGER.info("getItemById with id: [{}]", id);
        var itemDto = itemService.findById(id)
                .map(itemConverter::fromItem)
                .orElse(ItemDto.builder().build());
        model.addAttribute(ONE_ITEM_KEY, itemDto);
        return "items/show-item-page";
    }

    @GetMapping("/all-items")
    String getAllItems(Model model) {
        LOGGER.info("getAllItems");
        var allItemsDto = itemService.findAllItems()
                .stream()
                .map(itemConverter::fromItem)
                .collect(Collectors.toList());
        LOGGER.info("Items found: {}", allItemsDto);
        model.addAttribute(MANY_ITEMS_KEY, allItemsDto);
        return "items/all-items";
    }

    @GetMapping("/add-item")
    String addItem() {
        LOGGER.info("addItem()");

        return "/items/add-edit";
    }

    @PostMapping("/save-item")
    String saveItem(@Valid ItemDto itemToSave) {

        return "redirect://items" + itemToSave.getId();
    }
}
