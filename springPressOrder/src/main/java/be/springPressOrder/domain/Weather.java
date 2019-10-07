package be.springPressOrder.domain;

import java.util.Date;

public class Weather {

    // https://samples.openweathermap.org/data/2.5/weather?q=Brussels,be&appid=0f8f5b5a523075a9c3757f2534e00e0c
    //@JsonBackReference
    private int averageAmountOfRain;
    private int avarageHoursOfSun;
    private double avarageWindSpeed;
    private double avarageTemperature;
    private double humidity;
    private Date beginDate;
    private Date endDate;

    public Weather(int averageAmountOfRain, int avarageHoursOfSun, double avarageWindSpeed, double avarageTemperature, Date beginDate, Date endDate) {
        this.averageAmountOfRain = averageAmountOfRain;
        this.avarageHoursOfSun = avarageHoursOfSun;
        this.avarageWindSpeed = avarageWindSpeed;
        this.avarageTemperature = avarageTemperature;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Weather(int avarageTemperature, double humidity){
        this.avarageTemperature = avarageTemperature;
        this.humidity = humidity;
    }

    public int getAverageAmountOfRain() {
        return averageAmountOfRain;
    }

    public int getAvarageHoursOfSun() {
        return avarageHoursOfSun;
    }

    public double getAvarageWindSpeed() {
        return avarageWindSpeed;
    }

    public double getAvarageTemperature() {
        return avarageTemperature;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
