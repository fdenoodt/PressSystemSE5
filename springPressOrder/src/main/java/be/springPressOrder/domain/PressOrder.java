package be.springPressOrder.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pressorders")
public class PressOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int fruitAmount;
    private int maxJuiceAmount;
    private Status status;

    @OneToOne(mappedBy = "pressOrder")
    private Order order;

    @OneToMany(mappedBy = "pressOrder")
    private Set<Schedule> schedules;

    public PressOrder(int fruitAmount, int maxJuiceAmount, Order order){
        this.fruitAmount = fruitAmount;
        this.maxJuiceAmount = maxJuiceAmount;
        this.status = Status.NOT_PLANNED;
        this.order = order;
        schedules = new HashSet<>();
    }
    public PressOrder(int fruitAmount, int maxJuiceAmount){
        this.fruitAmount = fruitAmount;
        this.maxJuiceAmount = maxJuiceAmount;
        this.status = Status.NOT_PLANNED;
        schedules = new HashSet<>();
    }

    public PressOrder(){
        schedules = new HashSet<>();
    }

    public void setFruitAmount(int fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public void setMaxJuiceAmount(int maxJuiceAmount) {
        this.maxJuiceAmount = maxJuiceAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFruitAmount() {
        return fruitAmount;
    }

    public int getMaxJuiceAmount() {
        return maxJuiceAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }
}
