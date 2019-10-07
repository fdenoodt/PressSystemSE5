package be.springPressOrder.dao;

import be.springPressOrder.domain.Fruit;
import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<Fruit, Integer> {

}
