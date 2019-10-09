package be.springPressOrder.services;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class PressSystemServiceImpl implements PressSystemService {
    private PressOrderRepository pressOrderRepository;
    private FruitRepository fruitRepository;
    private OrderRepository orderRepository;
    private ScheduleRepository scheduleRepository;
    private MachineRepository machineRepository;
    private TechnicianRepository technicianRepository;
    private RequestTechnicianRepository requestTechnicianRepository;
    private UserRepository userRepository;
    private StorageRepository storageRepository;
    private FruitDataRepository fruitDataRepository;

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) { this.pressOrderRepository = pressOrderRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository){this.scheduleRepository = scheduleRepository;}

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository){this.machineRepository = machineRepository;}

    @Autowired
    public void setTechnicianRepository(TechnicianRepository technicianRepository){this.technicianRepository = technicianRepository;}

    @Autowired
    public void setRequestTechnicianRepository (RequestTechnicianRepository requestTechnicianRepository){this.requestTechnicianRepository = requestTechnicianRepository;}

    @Autowired
    public void setStorageRepository (StorageRepository storageRepository){this.storageRepository = storageRepository;}

    @Autowired
    public void setFruitDataRepository (FruitDataRepository fruitDataRepository){this.fruitDataRepository=fruitDataRepository;}

    @Override
    public Iterable<PressOrder> listAllPressOrders() {
        return pressOrderRepository.findAll();
    }

    @Override
    public PressOrder getPressOrderById(Integer id) {
        return pressOrderRepository.findOne(id);
    }

    @Override
    public Iterable<PressOrder> listPressOrderByOrder(Integer idOrder) {
        ArrayList<PressOrder> result = new  ArrayList<>();
        for (PressOrder pressOrder : pressOrderRepository.findAll())
        {
            if(pressOrder.getOrder().getId() == idOrder)
                result.add(pressOrder);
        }
        return result;
    }

    @Override
    public Iterable<Fruit> listAllFruits(){
        return fruitRepository.findAll();
    }

    @Override
    public OrderData getDataOrderById(int id) {
        Order order = getOrderById(id);
        OrderData od =new OrderData();
        od.setId(order.getId());
        od.setUserId(order.getUser().getId());
        od.setAmount(order.getAmount());
        od.setFruitId(order.getFruit().getId());
        return  od;
    }

    @Override
    public Iterable<PressOrder> listPressOrderByFruit(String fruitName) {
        ArrayList<PressOrder> result = new  ArrayList<>();
        for (PressOrder pressOrder : pressOrderRepository.findAll())
        {
            if(pressOrder.getOrder().getFruit().getName().equals(fruitName))
                result.add(pressOrder);
        }
        return result;
    }

    @Override
    public PressOrder addPressOrder(int amountOfFruit, Fruit fruit, int maxJuiceAmount, Integer idClient) {
       return pressOrderRepository.save(createPressOrder(amountOfFruit,fruit,maxJuiceAmount,idClient));
    }

    @Override
    public PressOrder savePressOrder(int id, int amountOfFruit, Fruit fruit, int maxJuiceAmount, int idClient) {
        return null;
    }

    @Override
    public void deletePressOrder(Integer id) {
        pressOrderRepository.delete(id);
    }

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> listOrderByFruit(String  fruitName) {
        return null;
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order addOrder(int amount, Fruit fruit, Integer idClient) {
        return orderRepository.save(createOrder(amount,fruit,idClient));
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.delete(id);
    }

    @Override
    public void deleteSchedule(Integer id){scheduleRepository.delete(id);}

    private Order createOrder(int amount, Fruit fruit, Integer idClient){
        return new Order(amount,fruit,userRepository.findOne(idClient));
    }

    private PressOrder createPressOrder(int amountOfFruit, Fruit fruit, int maxJuiceAmount, Integer userId){
        Order order = createOrder(0,fruit,userId);
        return new PressOrder(amountOfFruit,maxJuiceAmount,order);
    }

    @Override
    public Order processOrder(OrderData orderData){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Order order;
        if(orderData.getId() != 0)
            order = orderRepository.findOne(orderData.getId());
        else
            order = new Order();
        order.setAmount(orderData.getAmount());
        order.setUser(userRepository.findOne(orderData.getUserId()));
        order.setFruit(fruitRepository.findOne(orderData.getFruitId()));
        order = orderRepository.save(order);
        return order;
    }

    @Override
    public PressOrder processPressOrder(PressOrderData pressOrderData){
        Order order = new Order(0,fruitRepository.findOne(pressOrderData.fruitId),userRepository.findOne(pressOrderData.userId));
        orderRepository.save(order);
        PressOrder pressOrder = new PressOrder(pressOrderData.fruitAmount,pressOrderData.maxJuiceAmount,order);
        return pressOrderRepository.save(pressOrder);
    }

    @Override
    public ScheduleData getNewScheduleData(){
        return new ScheduleData();
    }

    @Override
    public User getUserByName(String name){
        return userRepository.findByUsername(name);
    }

    @Override
    public ScheduleData prepareScheduleData(int id){
        Schedule schedule = scheduleRepository.findOne(id);
        ScheduleData scheduleData = new ScheduleData();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        scheduleData.id = schedule.getId();
        scheduleData.machineId = schedule.getMachine().getId();
        scheduleData.pressOrderId = schedule.getPressOrder().getId();
        scheduleData.beginHour = format.format(schedule.getStartHour());
        scheduleData.endHour = format.format(schedule.getEndHour());
        return scheduleData;
    }

    @Override
    public List<PressOrder> listAllPressOrdersByUser(Integer userId){
        return pressOrderRepository.findAllByOrder_User(userRepository.findOne(userId));
    }

    @Override
    public List<Order> listAllOrdersByUser(Integer userId){
        return orderRepository.findAllByUser(userRepository.findOne(userId));
    }

    @Override
    public Iterable<Schedule> listAllSchedules(){
        return scheduleRepository.findAll();
    }
    
    @Override
    public void ChangeMachineStatus(int id)
    {
        machineRepository.findOne(id).setStatus(Machine.Status.Ok);
        System.out.println("***********************************************************************************************************************************************************");
        System.out.println(machineRepository.findOne(id).getStatus());

    }

    @Override
    public String processSchedule(ScheduleData scheduleData) throws ParseException {
        String message = "";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Schedule schedule;
        if(scheduleData.getId() != 0)
            schedule = scheduleRepository.findOne(scheduleData.getId());
        else
            schedule = new Schedule();
        schedule.setMachine(machineRepository.findOne(scheduleData.machineId));
        schedule.setPressOrder(pressOrderRepository.findOne(scheduleData.pressOrderId));
        schedule.setStartHour(format.parse(scheduleData.beginHour));
        schedule.setEndHour(format.parse(scheduleData.endHour));
        schedule = scheduleRepository.save(schedule);
        return String.format("Press order has been scheduled with id %d",schedule.getId());
    }

    @Override
    public Iterable<Machine> listAllMachines(){
        return machineRepository.findAll();
    }

    @Override
    public Machine getMachineById(int id){return machineRepository.findOne(id);}

    @Override
    public List<Schedule> getSchedulesByMachine(Machine machine){return scheduleRepository.findAllByMachine(machine);}


    @Override
    public Iterable<Technician> listAllTechnicians(){
        return technicianRepository.findAll();
    }

    @Override
    public Technician getTechnicianById(int id){
        return technicianRepository.findOne(id);
    }

    @Override
    public Iterable<RequestTechnician> listAllRequestTechnicians(){
        return requestTechnicianRepository.findAll();
    }

    @Override
    public RequestTechnician getRequestTechnicianById(int id){
        return requestTechnicianRepository.findOne(id);
    }

    @Override
    public RequestTechnician processRequestTechnician(RequestTechnicianData requestTechnicianData){
        return requestTechnicianRepository.save(new RequestTechnician(requestTechnicianData.sendDate,requestTechnicianData.message,technicianRepository.findOne(requestTechnicianData.technicianId)));
    }

    @Override
    public void deleteRequest(Integer id){
        requestTechnicianRepository.delete(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user != null) return user;
        throw new UsernameNotFoundException("User "+username+" not found!");
    }

    @Override
    public List<RequestTechnician> getRequestTechnicianByTechnician(Technician technician){
        return requestTechnicianRepository.getAllByTechnician(technician);
    }

    public Iterable<Storage> listAllStorages(){
        return storageRepository.findAll();
    }

    public double predictAmountOfJuice(Integer pressOrderId){
        PressOrder po = pressOrderRepository.findById(pressOrderId);
        Order o  = orderRepository.findOrderByPressOrder(po);
        FruitData fd = fruitDataRepository.findByFruit(o.getFruit());
        return po.getFruitAmount() * fd.getAvgJuiceAmount();
    }

    public Storage getStorageById(int id){
        return storageRepository.findOne(id);
    }

    @Override
    public void checkMachinesStatus(){
        Iterable<Machine> machines = machineRepository.findAll();
        for (Machine machine:machines) {
            Machine.Status oldStatus = machine.getStatus();
            if(machine.getStatus() == Machine.Status.Ok){
                int hoursActive = 0;
                for (Schedule schedule:machine.getSchedules()) {
                    hoursActive += (schedule.getEndHour().getTime() - schedule.getStartHour().getTime())/(60 * 60 * 1000) % 24;
                }
                double errorChance = 0.1 + 0.0012 * hoursActive;
                if(Math.random() < errorChance)
                    machine.setStatus(Machine.Status.Not_OK);
            }
            machine.addRapport(new Rapport(machine,oldStatus,machine.getStatus(),""));
            machineRepository.save(machine);
        }
    }

    @Override
    public Prediction predictFruitAmount(Integer storageId){
        Weather weather = getWeatherData();
        Storage storage = storageRepository.findOne(storageId);
        Fruit fruit = fruitRepository.findOne(storage.getFruit().getId());
        FruitData fruitData = fruitDataRepository.findByFruit(fruit);
        if(fruitData.getMaximumAverageWindSpeed() > weather.getAvarageWindSpeed()
                && fruitData.getRequiredAvergeHoursOfSunPerDay() < weather.getAvarageHoursOfSun()
                && fruitData.getRequiredRainFallPerWeek() > weather.getAverageAmountOfRain())
        return new Prediction(fruit,new Date(),new Date(), Prediction.PredictionState.HIGH);
        else if(fruitData.getMaximumAverageWindSpeed() > weather.getAvarageWindSpeed()
                && fruitData.getRequiredAvergeHoursOfSunPerDay() > weather.getAvarageHoursOfSun()
                && fruitData.getRequiredRainFallPerWeek() > weather.getAverageAmountOfRain())
            return new Prediction(fruit,new Date(),new Date(), Prediction.PredictionState.AVERAGE);
        else
            return new Prediction(fruit,new Date(),new Date(), Prediction.PredictionState.LOW);
    }

    public void pressPressOrder(int pressOrderId){
        try {
            PressOrder po = getPressOrderById(pressOrderId);
            FruitData fruitData = fruitDataRepository.findByFruit(po.getOrder().getFruit());
            po.setStatus(Status.READY);
            int amountOfJuiceTotal = (int) Math.round(po.getFruitAmount() * fruitData.getAvgJuiceAmount());
            Juice juiceForClient = new Juice();
            if (amountOfJuiceTotal > po.getMaxJuiceAmount()) {
                juiceForClient.setAmount(po.getMaxJuiceAmount());
                Juice restJuice = new Juice();
                restJuice.setAmount(amountOfJuiceTotal - po.getMaxJuiceAmount());
                Storage storage = storageRepository.findStorageByFruit(po.getOrder().getFruit());
                storage.addJuice(restJuice);
                storageRepository.save(storage);
            } else
                juiceForClient.setAmount(po.getMaxJuiceAmount());
            po.getOrder().setAmount(juiceForClient.getAmount());
            po.getOrder().addJuice(juiceForClient);
            pressOrderRepository.save(po);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override
    public Boolean checkEnoughInStock(int storageId,int amount){
        Storage storage =storageRepository.findOne(storageId);
        return storage.getTotal() >= amount;
    }

    @Override
    public Storage getStorageForFruit(int fruitId){
        return storageRepository.findStorageByFruit(fruitRepository.findOne(fruitId));
    }

    @Override
    public void getJuicesForOrder(int orderId) {
        try {
            Order order = getOrderById(orderId);
            Storage storage = storageRepository.findStorageByFruit(order.getFruit());
            if (checkEnoughInStock(storage.getId(), order.getAmount())) {
                if (storage.getTotal() == order.getAmount()) {
                    order.setJuices(storage.getJuices());
                    storage.getJuices().clear();
                }
                Set<Juice> juices = storage.getJuices();
                for (Juice juice : juices) {
                    if (juice.getAmount() <= order.getAmount()) {
                        order.addJuice(juice);
                        order.setAmount(order.getAmount() - juice.getAmount());
                        storage.removeJuice(juice);
                        if (order.getAmount() == 0)
                            break;
                    } else {
                        Juice orderJuice = new Juice(juice.getFruit(), order.getAmount(), juice.getPressDate(), juice.getFromClient());
                        order.addJuice(orderJuice);
                        juice.setAmount(juice.getAmount() - order.getAmount());
                        break;
                    }
                }
                orderRepository.save(order);
                storageRepository.save(storage);
            } else
                order.setStatus(Status.CANCLED);
        } catch (Exception err) {
            System.out.println((err));
        }
    }

    private Weather getWeatherData(){
        RestTemplate rt = new RestTemplate();
        Weather weather = rt.getForObject("http://localhost:8081/weather", Weather.class);
        return weather;
    }
}
