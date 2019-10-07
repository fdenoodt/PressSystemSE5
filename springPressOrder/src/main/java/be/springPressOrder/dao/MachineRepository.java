package be.springPressOrder.dao;

import be.springPressOrder.domain.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository<Machine,Integer> {
}
