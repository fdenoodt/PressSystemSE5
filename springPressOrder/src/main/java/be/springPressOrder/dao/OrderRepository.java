package be.springPressOrder.dao;

import be.springPressOrder.domain.Client;
import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.domain.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAllByUser(User user);

    public Order findById(int id);

    Order findOrderByPressOrder(PressOrder pressOrder);

    //public Order findOrderByUser(User user);

    //public List<Order> findAllByUserOrderByName(User user);

}
