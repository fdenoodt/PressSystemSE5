package be.springPressOrder.dao;

import be.springPressOrder.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, String> {
    Person findByUsername(String username);
}
