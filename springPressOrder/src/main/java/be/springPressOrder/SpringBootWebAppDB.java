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
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Autowired
    public void setTechnicianRepository(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @Autowired
    public void setRequestTechnicianRepository(RequestTechnicianRepository requestTechnicianRepository) {
        this.requestTechnicianRepository = requestTechnicianRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Autowired
    public void setStorageRepository(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Autowired
    public void setJuiceRepository(JuiceRepository juiceRepository) {
        this.juiceRepository = juiceRepository;
    }

    @Autowired
    public void setFruitDataRepository(FruitDataRepository fruitDataRepository) {
        this.fruitDataRepository = fruitDataRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = new User("admin", "admin", "047", "mail@mail.be", "admin", "ROLE_ADMIN", "{noop}password");
        userRepository.save(user);

        Fruit fruit = new Fruit("Apple");
        fruitRepository.save(fruit);

        Fruit pear = new Fruit("Pear");
        fruitRepository.save(pear);
    }
}
