package am.task.kitchen.service.impl;

import am.task.kitchen.model.Ingredient;
import am.task.kitchen.model.exception.NotFoundException;
import am.task.kitchen.repository.IngredientRepository;
import am.task.kitchen.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    @Transactional
    public Ingredient add(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    @Transactional
    public Ingredient supplement(Long id, int count) throws NotFoundException {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("wrong_id"));
        ingredient.setCount(ingredient.getCount() + count);
        return ingredient;
    }
}
