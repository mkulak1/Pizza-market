package pl.wszib.pizzamarket.web.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wszib.pizzamarket.services.PizzaService;
import pl.wszib.pizzamarket.web.models.PizzaModel;

import java.util.List;

@Controller
public class MenuController {

    private final PizzaService pizzaService;

    public MenuController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("menu")
    public String menuPage(Model model) {

        List<PizzaModel> pizzas = pizzaService.findAll();

        model.addAttribute("pizzas", pizzas);


        return "menuPage";
    }
}
