package be.springPressOrder.dao;

import be.springPressOrder.domain.Machine;
import be.springPressOrder.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    public List<Schedule> findAllByMachine(Machine machine);
}
