package am.task.kitchen.controller;


import am.task.kitchen.model.Ingredient;
import am.task.kitchen.model.exception.NotFoundException;
import am.task.kitchen.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {


    @Autowired
    private IngredientService ingredientService;


    @PostMapping
    @RolesAllowed("ROLE_SUPPLIER")
    //es controllerov pahesti ashxatox@ taza ingridient a avelacnum
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient){
        ingredient = ingredientService.add(ingredient);
        return ResponseEntity.ok(ingredient);
    }


    @RolesAllowed("ROLE_SUPPLIER")
    @PatchMapping("/{id}/supplement/{count}")
    //es controllerov pahesti ashxatox@  exac ingridientneri qanakna avelacnum
    public ResponseEntity<Ingredient> add(@PathVariable Long id,@PathVariable int count){
        try {
            Ingredient ingredient = ingredientService.supplement(id,count);
            return ResponseEntity.ok(ingredient);
        }catch (NotFoundException ex){
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping
    //es controllerov prosto talis a ingridientneri cucak@
    public ResponseEntity<List<Ingredient>> getIngredients( ){
        List<Ingredient> ingredients = ingredientService.getAll();
        return ResponseEntity.ok(ingredients);
    }



}
