package be.springPressOrder.dao;

import be.springPressOrder.domain.Fruit;
import be.springPressOrder.domain.Storage;
import org.springframework.data.repository.CrudRepository;

public interface StorageRepository extends CrudRepository<Storage,Integer> {

    public Storage findStorageByFruit(Fruit fruit);
}
