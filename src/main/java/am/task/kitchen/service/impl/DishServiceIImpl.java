package am.task.kitchen.service.impl;

import am.task.kitchen.model.Dish;
import am.task.kitchen.model.Ingredient;
import am.task.kitchen.repository.DishRepository;
import am.task.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DishServiceIImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public Dish add(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> getPossibleByIngredients(Set<Ingredient> ingredients) {
        List<Long> ingredientIds = ingredients.stream().map(Ingredient::getId).collect(Collectors.toList());
        List<Dish> result = new ArrayList<>();

        //vercnum enq bazaic bolor utestner@ voronc gone 1 ingridient@ hamapatasxanum a mer ingridientneri het u qanak@ 0ic avela
        List<Dish> possibleDishes = dishRepository.getAllByIngredients(ingredientIds);

        //stugum enq ardyoq bolor ingridientneric e harcrel
        for (Dish dish : possibleDishes) {
            boolean canMake = true;
            for (Ingredient ingredient : dish.getIngredients()) {
                if (!ingredients.contains(ingredient)) {
                    canMake = false;
                    break;
                }
            }
            if (canMake) {
                result.add(dish);
            }
        }
        return result;
    }

}
