package be.springPressOrder.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Sorts")
public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade=CascadeType.ALL)
    private Fruit fruitName;

    private Double averageJuicePercentage;
    private Date startMonth;
    private Date endMonth;

    /*@OneToOne(cascade=CascadeType.ALL)
    private Juice juice;*/

    public Sort(Fruit fruitName, Double averageJuicePercentage, Date startMonth, Date endMonth) {
        this.fruitName = fruitName;
        this.averageJuicePercentage = averageJuicePercentage;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    public Fruit getFruitName() {
        return fruitName;
    }

    public Double getAverageJuicePercentage() {
        return averageJuicePercentage;
    }

    public Date getStartMonth() {
        return startMonth;
    }

    public Date getEndMonth() {
        return endMonth;
    }

    public void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    public void setEndMonth(Date endMonth) {
        this.endMonth = endMonth;
    }
}
