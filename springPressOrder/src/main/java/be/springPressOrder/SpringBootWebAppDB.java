package be.springPressOrder;

import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
//import cucumber.api.java.cs.A;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Component
public class SpringBootWebAppDB implements ApplicationListener<ContextRefreshedEvent> {

    private PressOrderRepository pressOrderRepository;
    private OrderRepository orderRepository;
    private FruitRepository fruitRepository;
    private MachineRepository machineRepository;
    private ScheduleRepository scheduleRepository;
    private TechnicianRepository technicianRepository;
    private RequestTechnicianRepository requestTechnicianRepository;
    private UserRepository userRepository;
    private StorageRepository storageRepository;
    private JuiceRepository juiceRepository;
    private FruitDataRepository fruitDataRepository;



    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) { this.pressOrderRepository = pressOrderRepository; }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository) { this.fruitRepository = fruitRepository; }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository){this.scheduleRepository = scheduleRepository;}

    @Autowired
    public void setTechnicianRepository(TechnicianRepository technicianRepository){this.technicianRepository =technicianRepository;}

    @Autowired
    public void setRequestTechnicianRepository(RequestTechnicianRepository requestTechnicianRepository){this.requestTechnicianRepository = requestTechnicianRepository;}

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository){this.machineRepository = machineRepository;}

    @Autowired
    public void setStorageRepository(StorageRepository storageRepository){this.storageRepository=storageRepository;}

    @Autowired
    public void setJuiceRepository(JuiceRepository juiceRepository){this.juiceRepository=juiceRepository;}

    @Autowired
    public void setFruitDataRepository(FruitDataRepository fruitDataRepository){this.fruitDataRepository = fruitDataRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User user = new User("admin","admin","047","mail@mail.be","admin","ROLE_ADMIN","{noop}password");
        User pierre = new User("vanvolsem","pierre","047","mail@mail.be","user","ROLE_USER","{noop}password");

        User user4 = new User("Klochkova","Alex","05","a@k.com","user8","ROLE_USER",
                "{noop}password");
        User user6 = new User("Klochkova","Alex","05","a@k.com","user2","ROLE_USER",
                "{noop}password");
        userRepository.save(user);
        userRepository.save(user4);
        userRepository.save(user6);
        userRepository.save(pierre);

        Fruit fruit = new Fruit("Apple");
        fruitRepository.save(fruit);
        FruitData fd = new FruitData(fruit,0.65,8,11,5,5,5);
        fruit.setFruitData(fd);
        fruitDataRepository.save(fd);
        fruitRepository.save(fruit);

        Storage storage = new Storage(fruit,3.0);
//        Juice juice1 = new Juice(fruit,50,new Date(),1);
//        juiceRepository.save(juice1);
//        storage.addJuice(juice1);
        storageRepository.save(storage);


        machineRepository.save(new Machine());

        List<Order> orders = Arrays.asList(
                new Order(50,fruit,user4),
                new Order(50,fruit,user4),
                new Order(50,fruit,user4));

        orderRepository.save(orders);

        Order order2 = new Order(50,fruit,user4);
        orderRepository.save(order2);

        List<PressOrder> pressOrders = Arrays.asList(
                new PressOrder(100, 99),
                new PressOrder(1, 7),
                new PressOrder(2, 6));

        for (int i = 0; i<orders.size();i++){{
            pressOrders.get(i).setOrder(orders.get(i));
            orders.get(i).setPressOrder(pressOrders.get(i));

        }}
        pressOrderRepository.save(pressOrders);
        orderRepository.save(orders);

        PressOrder pressOrder1 = new PressOrder(100, 99, order2);
        pressOrderRepository.save(pressOrder1);
        //log.info("Saved press order1 - id: " + pressOrder1.getId());

        Order order3 = new Order(50,fruit,user6);
        orderRepository.save(order3);
        PressOrder pressOrder2 = new PressOrder(1, 7,  order3);
        pressOrderRepository.save(pressOrder2);
        //log.info("Saved press order2 - id: " + pressOrder2.getId());

        Order order4 = new Order(50,fruit,user6);
        orderRepository.save(order4);
        PressOrder pressOrder3 = new PressOrder(2, 6, order4);
        pressOrderRepository.save(pressOrder3);
        //log.info("Saved press order3 - id: " + order3.getId());
        Fruit pear = new Fruit("Pear");
        fruitRepository.save(pear);
        FruitData pearData = new FruitData(pear,0.7,9,11,40,5,20);
        fruitDataRepository.save(pearData);
        Storage storagePear = new Storage(pear,4);
        storageRepository.save(storagePear);
        Order order1 = new Order(2,pear,user6);
        orderRepository.save(order1);
        ///log.info("Saved order1 - id: " + order1.getId());

        Machine machine1 = new Machine(1,false,100);
        Machine machine2 = new Machine(2,false,100);
        Machine machine3 = new Machine(3,false,100);
        machineRepository.save(machine1);
        machineRepository.save(machine2);
        machineRepository.save(machine3);

        Technician technician1 = new Technician("Duck","James","+32479019788","JamesDuck@Duck.com"
                ,"TECHNICIAN","ROLE_TECHNICIAN","{noop}password");

        Technician technician2 = new Technician("Flamingo","Jeff","+32488527488","JeffFlamingo@Duck.com"
                ,"TECHNICIAN2","ROLE_TECHNICIAN","{noop}password");

        userRepository.save(technician1);
        userRepository.save(technician2);


        RequestTechnician request1 = new RequestTechnician(new Date(),"Machine 1 and 2 stopped working",technician1);

        RequestTechnician request2 = new RequestTechnician(new Date(),"Machine 1 has some issues",technician1);

        RequestTechnician request3 = new RequestTechnician(new Date(),"Machine 3 wont boot",technician2);

        RequestTechnician request4 = new RequestTechnician(new Date(),"Machine 2 wont boot",technician2);

        requestTechnicianRepository.save(request1);
        requestTechnicianRepository.save(request4);
        requestTechnicianRepository.save(request2);
        requestTechnicianRepository.save(request3);

        /*technician1.getRequestTechnicians().add(request1);
        technician1.getRequestTechnicians().add(request2);
        technician2.getRequestTechnicians().add(request3);
        technician2.getRequestTechnicians().add(request4);*/

        //technicianRepository.save(technician1);
        //technicianRepository.save(technician2);

       /* requestTechnicianRepository.save(request1);
        requestTechnicianRepository.save(request4);
        requestTechnicianRepository.save(request2);
        requestTechnicianRepository.save(request3);*/

        Schedule schedule = new Schedule(machine1,pressOrder1,new Date(),new Date());

        scheduleRepository.save(schedule);

        User user5 = new User("Vanvolsem","Pierre","03","p@v.com","pv","ROLE_PRESSER",
                "{noop}presser");
        userRepository.save(user5);

        User user2 = new User("Sahan","Hakan","04","h@s.com","hs","ROLE_ADMIN",
                "{noop}admin");
        userRepository.save(user2);

        User user3 = new User("Klochkova","Alex","05","a@k.com","ak","ROLE_TECHNICIAN",
                "{noop}tech");
        userRepository.save(user3);
    }
}
