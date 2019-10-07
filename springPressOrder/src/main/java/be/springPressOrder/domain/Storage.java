package be.springPressOrder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Storage")
@XmlRootElement(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Fruit cannot be null")
    @OneToOne()
    @JoinColumn(name = "fruit_id", referencedColumnName = "id")
    private Fruit fruit;

    @OneToMany(mappedBy = "storage")
    private Set<Juice> juices;

    private int total;

    private double price;

    public Storage(Fruit fruit, Set<Juice> juices, int total, double price) {
        this.fruit = fruit;
        this.juices = juices;
        this.total = total;
        this.price = price;
    }

    public Storage(Fruit fruit, double price){
        this.fruit = fruit;
        this.juices = new HashSet<>();
        this.price = price;
    }

    public Storage(){

    }

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    @XmlElement(name="fruit")
    public Fruit getFruit() { return fruit; }

    //@XmlElement(name="juices")
    public Set<Juice> getJuices() {
        return juices;
    }

    @XmlElement(name="total")
    public int getTotal() {
        return total;
    }

    @XmlElement(name="price")
    public double getPrice(){return price;}

    public void addJuice(Juice juice){
        juices.add(juice);
        total += juice.getAmount();
    }

    public void removeJuice(Juice juice){
        if(juices.contains(juice)) {
            juices.remove(juices);
            total -= juice.getAmount();
        }
    }
}
