package be.springPressOrder.dao;

import be.springPressOrder.domain.Fruit;
import be.springPressOrder.domain.FruitData;
import org.springframework.data.repository.CrudRepository;

public interface FruitDataRepository extends CrudRepository<FruitData,Integer> {
    public FruitData findByFruit(Fruit fruit);
}
