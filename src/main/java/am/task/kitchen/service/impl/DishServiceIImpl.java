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
    public List<Dish> getPossibleByIngredients() {
      
        return  new ArrayList<>();
    }

}
