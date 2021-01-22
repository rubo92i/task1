package am.task.kitchen.service.impl;

import am.task.kitchen.model.Dish;
import am.task.kitchen.model.Ingredient;
import am.task.kitchen.model.exception.NotAcceptableException;
import am.task.kitchen.model.exception.NotFoundException;
import am.task.kitchen.repository.DishRepository;
import am.task.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<Dish> getPossible() {
        return dishRepository.getAllPossibleDishes();
    }

    @Override
    @Transactional
    public Dish makeDish(long id) throws NotFoundException, NotAcceptableException {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("wrong_id"));
        for (Ingredient ingredient : dish.getIngredients()) {
            if (ingredient.getCount() <= 0) {
                throw new NotAcceptableException("no such ingredients");
            }
            ingredient.setCount(ingredient.getCount() - 1);
        }
        return dish;
    }

}
