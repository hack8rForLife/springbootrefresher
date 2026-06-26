package com.example.springbootfullrefresher.controller;

import com.example.springbootfullrefresher.model.Ingredient;
import com.example.springbootfullrefresher.model.Taco;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignFoodController {

    Logger logger = LoggerFactory.getLogger(DesignFoodController.class);

    private List<Ingredient> getIngredients(){
        return Arrays.asList(
                new Ingredient("FLTO","Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO","Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
    }

    private void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = getIngredients();
        for (Ingredient.Type type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .toList();
    }

    //endpoints
    @GetMapping
    public String showDesignForm(Model model){
        addIngredientsToModel(model);
        model.addAttribute("design", new Taco());
        return "design";
    }


    @PostMapping
    public String processDesignForm(@Valid Taco design, Errors errors, Model model){
        if(errors.hasErrors()){
            addIngredientsToModel(model);
            return "design";
        }
        logger.info("Processing Design Form");
        return "redirect:/orders/current";
    }
}