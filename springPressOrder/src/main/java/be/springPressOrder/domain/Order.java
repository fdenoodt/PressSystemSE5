package be.springPressOrder.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @Digits(integer=3, fraction=0, message = "Please select an amount less than thousand ")
    private int amount;

    @Column
    private Status status;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "fruid_id")
    private Fruit fruit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pressOrder_id", referencedColumnName = "id")
    private PressOrder pressOrder;

    @OneToMany(mappedBy = "order")
    private Set<Juice> juices;

    public Order(){
        orderDate = new Date();
        status = Status.NOT_PLANNED;
    }

    public Order(int amount, Fruit fruit, User user){
        this.amount = amount;
        this.fruit = fruit;
        this.user = user;
        juices = new HashSet<>();
        orderDate = new Date();
        status = Status.NOT_PLANNED;
    }

    public void setIdClient(User user) {
        this.user = user;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<Juice> getJuices() {
        return juices;
    }

    public User getUser() {
        return user;
    }

    public PressOrder getPressOrder() {
        return pressOrder;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void addJuice(Juice juice){juices.add(juice);}

    public void setJuices(Set<Juice> juices){this.juices = juices;}

    public void setPressOrder(PressOrder pressOrder){this.pressOrder = pressOrder;}

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
