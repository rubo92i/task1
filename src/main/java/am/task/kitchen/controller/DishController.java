package am.task.kitchen.controller;


import am.task.kitchen.model.Dish;
import am.task.kitchen.model.Ingredient;
import am.task.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;


    @PostMapping
    @RolesAllowed("ROLE_CHIEF")
    // es controllerov cheief pover@ asum te vor dish@ inch ingridienta a ogtagrocum
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        dish = dishService.add(dish);
        return ResponseEntity.ok(dish);
    }


    @RolesAllowed("ROLE_MANAGER")
    @PostMapping("/get-possible-by-ingredients")
    public ResponseEntity<List<Dish>> getPossibleByIngredients(@RequestBody Set<Ingredient> ingredients) {
        List<Dish> dishes = dishService.getPossibleByIngredients(ingredients);
        return ResponseEntity.ok(dishes);
    }


}
