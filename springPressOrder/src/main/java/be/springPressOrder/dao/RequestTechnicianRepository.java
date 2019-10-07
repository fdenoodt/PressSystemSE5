package be.springPressOrder.dao;

import be.springPressOrder.domain.RequestTechnician;
import be.springPressOrder.domain.Technician;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestTechnicianRepository extends CrudRepository<RequestTechnician,Integer> {
    public List<RequestTechnician> getAllByTechnician(Technician technician);
}
