package be.springPressOrder.dao;

import be.springPressOrder.domain.Technician;
import org.springframework.data.repository.CrudRepository;

public interface TechnicianRepository extends CrudRepository<Technician, Integer> {
}
