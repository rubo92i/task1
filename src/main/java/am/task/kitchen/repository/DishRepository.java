package am.task.kitchen.repository;

import am.task.kitchen.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    String possible_dishes_query = "SELECT * FROM dish " +
            "WHERE id IN ( " +
            "    SELECT dish_id " +
            "    FROM dish_ingredient di " +
            "    WHERE (SELECT COUNT(*) " +
            "           FROM dish_ingredient " +
            "           WHERE dish_id = di.dish_id) = (SELECT COUNT(*) " +
            "                                          FROM ingredient " +
            "                                          WHERE ingredient.count > 0 " +
            "                                            AND ingredient.id IN " +
            "                                                (SELECT ingredient_id FROM dish_ingredient WHERE dish_id = di.dish_id) " +
            "          )" +
            ")";



    @Query(nativeQuery = true, value = possible_dishes_query)
    List<Dish> getAllPossibleDishes();


}
