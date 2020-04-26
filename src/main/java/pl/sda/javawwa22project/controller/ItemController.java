package pl.sda.javawwa22project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.javawwa22project.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @GetMapping("all-items")
    String getAllItems(Model model){
        List<Item> items = new ArrayList<>();

        model.addAttribute("items", items);
        return "items/all-items";
    }
}
