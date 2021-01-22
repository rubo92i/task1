package am.task.kitchen.service.impl;

import am.task.kitchen.repository.DishRepository;
import am.task.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceIImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;
}
