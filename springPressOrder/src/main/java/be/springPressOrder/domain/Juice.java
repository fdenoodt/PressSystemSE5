package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "Juices")
@XmlRootElement(name="juice")
public class Juice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   @OneToOne
    private Fruit fruit;

    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date pressDate;
    private int fromClient;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = true)
    private Storage storage;

    public Juice(Fruit fruit, int amount, Date presdate, int fromClient) {
        this.fruit = fruit;
        this.amount = amount;
        this.pressDate = presdate;
        this.fromClient = fromClient;
    }

    public Juice(){

    }

    @XmlElement(name="Fruit")
    public Fruit getFruit() {
        return fruit;
    }

    @XmlElement(name="amount")
    public int getAmount() {
        return amount;
    }

    @XmlElement(name="Presdate")
    public Date getPressDate() {
        return pressDate;
    }

    @XmlElement(name="Klant")
    public int getFromClient() {
        return fromClient;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPressDate(Date presdate) {
        this.pressDate = presdate;
    }

    public void setFromClient(int fromClient) {
        this.fromClient = fromClient;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // test klasses
    private int MinAmount = 5;
    private int MaxAmount = 100;

    public Juice(Fruit fruit, int amount, Date presdate, int fromClient, int maxAmount, int minAmount) throws Exception {
        this.fruit = fruit;
        this.MaxAmount = maxAmount;
        this.MinAmount = minAmount;
        this.amount = amount;
        this.pressDate = presdate;
        this.fromClient = fromClient;
        if(amount > maxAmount) throw new IllegalArgumentException("Amount mag niet groter zijn dan MaxAmount");
        if(minAmount > amount) throw new IllegalArgumentException("Amount moet groter zijn dan minAmount");
    }

    public void setAmount(int amount, int minAmount, int maxAmount) throws Exception {
        if(amount <= maxAmount && amount > minAmount) {
            this.amount = amount;}
        else throw new IllegalArgumentException("Amount moet voldoen aan min en max");
    }



}
