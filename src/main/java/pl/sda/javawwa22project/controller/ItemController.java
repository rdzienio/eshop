package pl.sda.javawwa22project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.javawwa22project.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

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
