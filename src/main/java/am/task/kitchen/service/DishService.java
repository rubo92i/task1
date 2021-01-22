package am.task.kitchen.service;

import am.task.kitchen.model.Dish;
import am.task.kitchen.model.exception.NotAcceptableException;
import am.task.kitchen.model.exception.NotFoundException;

import java.util.List;

public interface DishService {

    Dish add(Dish dish) throws NotFoundException;

    List<Dish> getPossible();

    Dish makeDish(long id) throws NotFoundException, NotAcceptableException;
}
