package be.springPressOrder.dao;

import be.springPressOrder.domain.Client;
import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PressOrderRepository extends CrudRepository<PressOrder, Integer> {

    public PressOrder findById(int id);

    List<PressOrder > findAllByOrder_User(User user);
    void delete(Integer id);
    PressOrder findByOrder(Order order);
}
