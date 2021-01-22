package am.task.kitchen.service;

import am.task.kitchen.model.Dish;
import am.task.kitchen.model.Ingredient;

import java.util.List;
import java.util.Set;

public interface DishService {

    Dish add(Dish dish);

    List<Dish> getPossibleByIngredients(Set<Ingredient> ingredients);

}
