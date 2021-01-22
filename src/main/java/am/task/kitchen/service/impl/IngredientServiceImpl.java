package am.task.kitchen.service.impl;

import am.task.kitchen.repository.IngredientRepository;
import am.task.kitchen.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;




}
