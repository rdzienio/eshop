package pl.sda.javawwa22project.controller;

import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.javawwa22project.converter.ItemConverter;
import pl.sda.javawwa22project.entity.Item;
import pl.sda.javawwa22project.service.ItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class ItemController {

    public static String ITEM_KEY = "itemToShow";
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
                .orElse(null);
        model.addAttribute(ITEM_KEY, itemDto);
        return "items/show-item-page";
    }

/*    private void sortItems(){
        Stream.of( new Item(1L, null, null, null, null, 5, null),
                new Item(2L, null, null, null, null, 5, null))
    .sorted());
    }*/

    // TODO
    // metoda wyświetla 3 przykładowe przedmioty
    @GetMapping("all-items")
    String getAllItems(Model model) {
        List<Item> itemLis = new ArrayList<>();
        // dodaj 3 przedmioty
        model.addAttribute("items", itemLis);
        return "items/all-items";
    }
}
