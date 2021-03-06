package am.task.kitchen.controller;


import am.task.kitchen.model.Dish;
import am.task.kitchen.model.exception.NotAcceptableException;
import am.task.kitchen.model.exception.NotFoundException;
import am.task.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {

    @Autowired
    private DishService dishService;


    @PostMapping
    @RolesAllowed("ROLE_CHIEF")
    public ResponseEntity createDish(@RequestBody Dish dish) {
        try {
            dish = dishService.add(dish);
            return ResponseEntity.ok(dish);
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).body("Selected ingredients not found");
        }
    }


    @RolesAllowed("ROLE_MANAGER")
    @GetMapping("/get-possible")
    public ResponseEntity<List<Dish>> getPossible() {
        List<Dish> dishes = dishService.getPossible();
        return ResponseEntity.ok(dishes);
    }


    @RolesAllowed("ROLE_MANAGER")
    @PatchMapping("/{id}/make")
    public ResponseEntity getPossibleByIngredients(@PathVariable long id) {
        try {
            Dish dish = dishService.makeDish(id);
            return ResponseEntity.ok(dish);
        } catch (NotFoundException e) {
            return ResponseEntity.status(400).body("dish not found");
        } catch (NotAcceptableException e) {
            return ResponseEntity.status(406).body("no such ingredients");
        }
    }


}
