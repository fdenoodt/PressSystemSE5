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

    private String fruit;

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

    public PressOrder(int fruitAmount, int maxJuiceAmount) {
        this.fruitAmount = fruitAmount;
        this.maxJuiceAmount = maxJuiceAmount;
        this.status = Status.NOT_PLANNED;
        schedules = new HashSet<>();
    }

    public PressOrder() {
        schedules = new HashSet<>();
    }


    public void setFruitAmount(int fruitAmount) throws Exception {
        if (fruitAmount >= 3 && fruit.equals("appel")) {
            this.fruitAmount = fruitAmount;
            this.maxJuiceAmount = (fruitAmount / 2);
        } else if (fruitAmount >= 4 && fruit.equals("peer")) {
            this.fruitAmount = fruitAmount;
            this.maxJuiceAmount = (fruitAmount / 3);
        } else
            throw new IllegalArgumentException("Een bestelling moet minimum 3 appelen omvatten");

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


    public void setFruit(String fruit) {
        if (fruit.equals("appel") || fruit.equals("peer"))
            this.fruit = fruit;
        else
            throw new IllegalArgumentException("Een bestelling kan enkel fruit of peer kan bevatten.");
    }

    public String getFruit() {
        return this.fruit;
    }

}
