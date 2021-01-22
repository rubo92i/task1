package am.task.kitchen.repository;

import am.task.kitchen.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM  dish  where id in" +
            "(    SELECT  dish_id  FROM dish_ingredient " +
            " where ingridient_id in(1) " +
            " and (SELECT ingridient.count from  ingridient where id  = ingridient_id )> 0" +
            "  )")
    List<Dish> getAllPossibleDishes();


}
