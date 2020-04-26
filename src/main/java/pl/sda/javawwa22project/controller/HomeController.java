package pl.sda.javawwa22project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/welcome", "/home", "/index"})
    String welcome(Model model) {
        return "index";
    }
}
