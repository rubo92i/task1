package am.task.kitchen.service;

import am.task.kitchen.model.Ingredient;
import am.task.kitchen.model.exception.NotFoundException;

import java.util.List;

public interface IngredientService {

    Ingredient add(Ingredient ingredient);

    List<Ingredient> getAll();


    Ingredient supplement(Long id, int count) throws NotFoundException;
}
