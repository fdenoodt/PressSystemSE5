package be.springPressOrder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Fruits_Data")
public class FruitData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "fruitData")
    private Fruit fruit;

    @NotNull(message = "Average juice amount cannot be null")
    private Double avgJuiceAmount;

    @NotNull(message = "Begin month cannot be null")
    private int plantMonth;

    @NotNull(message = "End month cannot be null")
    private int harvestMonth;

    @NotNull(message = "Required rainfall per week cannot be null")
    private int requiredRainFallPerWeek;

    private int requiredAvergeHoursOfSunPerDay;

    private int maximumAverageWindSpeed;

    public FruitData(Fruit fruit, Double avgJuiceAmount, int beginmonth, int endmonth, int requiredRainFallPerWeek, int requiredAvergeHoursOfSunPerDay, int maximumAverageWindSpeed) {
        this.fruit = fruit;
        this.avgJuiceAmount = avgJuiceAmount;
        this.plantMonth = beginmonth;
        this.harvestMonth = endmonth;
        this.requiredAvergeHoursOfSunPerDay = requiredAvergeHoursOfSunPerDay;
        this.requiredRainFallPerWeek = requiredRainFallPerWeek;
        this.maximumAverageWindSpeed = maximumAverageWindSpeed;
    }

    public FruitData(){}

    public Fruit getFruit(){return fruit;}

    public Double getAvgJuiceAmount() { return avgJuiceAmount; }

    public int getBeginmonth() { return plantMonth; }

    public int getEndmonth() {return harvestMonth;}

    public int getId(){return id;}

    public int getBeginMonth() {
        return plantMonth;
    }

    public int getEndMonth() {
        return harvestMonth;
    }

    public int getRequiredRainFallPerWeek() {
        return requiredRainFallPerWeek;
    }

    public int getRequiredAvergeHoursOfSunPerDay() {
        return requiredAvergeHoursOfSunPerDay;
    }

    public int getMaximumAverageWindSpeed() {
        return maximumAverageWindSpeed;
    }
}
