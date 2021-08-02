package com.matteo.demo.controller;

import com.matteo.demo.model.Ingredient;
import com.matteo.demo.model.Ingredient.Type;
import com.matteo.demo.model.Order;
import com.matteo.demo.model.Pizza;
import com.matteo.demo.repository.IngredientRepository;
import com.matteo.demo.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepository;
    private final PizzaRepository pizzaRepository;
    private List<Ingredient> ingredients;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @Autowired
    public DesignPizzaController(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, List<Ingredient> ingredients) {
        this.ingredientRepository = ingredientRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        this.ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        addIngredientsToModel(model);
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Pizza pizza, Errors errors, @ModelAttribute Order order, Model model) {
        addIngredientsToModel(model);
        if (errors.hasErrors()) {
            log.error(errors.getAllErrors().toString());
            return "design";
        }
        Pizza saved = pizzaRepository.save(pizza);
        order.addPizza(saved);
        return "redirect:/orders/current";
    }

    private void addIngredientsToModel(Model model) {
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}