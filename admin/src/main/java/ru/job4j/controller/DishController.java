package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.Dish;
import ru.job4j.service.DishRESTAPIService;

@Controller
@AllArgsConstructor
public class DishController {

    private final DishRESTAPIService service;
    @GetMapping("/mainDish")
    public String index(Model model) {
        model.addAttribute("dishes", service.findAll());
        return "dishMain";
    }

    @GetMapping("/addDish")
    public String addTask(Model model) {
        model.addAttribute("task", new Dish());
        return "addDish";
    }

    @PostMapping("/createDish")
    public String createDish(@ModelAttribute Dish dish) {
        var regUser = service.save(dish);
        return "redirect:/mainDish";
    }
}
