package be.springPressOrder.services;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.domain.*;

import java.text.ParseException;
import java.util.List;

//Hier worden de methodes aangemaakt. Maar deze zijn leeg, de body komt in de implementatie
public interface PressSystemService {
    Iterable<PressOrder> listAllPressOrders();
    
    //Vraagt persoder met een bepaade ID op
    PressOrder getPressOrderById(Integer id);    
    // Geef alle fruiten terug
    Iterable<Fruit>      listAllFruits();
    OrderData getDataOrderById(int id);

    Iterable<PressOrder> listPressOrderByOrder(Integer id);

    Iterable<PressOrder> listPressOrderByFruit(String fruitName);

    PressOrder addPressOrder(int amountOfFruit, Fruit fruit, int maxJuiceAmount, Integer userId);

    PressOrder savePressOrder(int id, int amountOfFruit, Fruit fruit, int maxJuiceAmount, int idClient);

    void deletePressOrder(Integer id);

    Iterable<Order> listAllOrders();

    Iterable<Order> listOrderByFruit(String fruitName);

    Order getOrderById(Integer id);

    Order addOrder(int amount, Fruit fruit, Integer userId);

    void deleteOrder(Integer id);

    void deleteSchedule(Integer id);

    ScheduleData getNewScheduleData();

    ScheduleData prepareScheduleData(int id);

    Order processOrder(OrderData orderData);

    PressOrder processPressOrder(PressOrderData pressOrderData);

    Iterable<Schedule> listAllSchedules();

    Iterable<Machine> listAllMachines();

    Machine getMachineById(int id);

    User getUserByName(String name);

    List<RequestTechnician> getRequestTechnicianByTechnician(Technician technician);

    List<Schedule> getSchedulesByMachine(Machine machine);

    void checkMachinesStatus();

    String processSchedule(ScheduleData scheduleData) throws ParseException;

    Iterable<Technician> listAllTechnicians();

    Technician getTechnicianById(int id);

    double predictAmountOfJuice(Integer pressOrderId);

    Iterable<RequestTechnician> listAllRequestTechnicians();

    RequestTechnician getRequestTechnicianById(int id);

    RequestTechnician processRequestTechnician(RequestTechnicianData requestTechnicianData);

    public Iterable<Storage> listAllStorages();

    void getJuicesForOrder(int orderId);

    Boolean checkEnoughInStock(int storageId,int amount);

    Storage getStorageForFruit(int fruitId);

    List<PressOrder> listAllPressOrdersByUser(Integer userId);

     void ChangeMachineStatus(int id);

    void deleteRequest(Integer id);
    public Prediction predictFruitAmount(Integer storageId);

    List<Order> listAllOrdersByUser(Integer userId);
}
