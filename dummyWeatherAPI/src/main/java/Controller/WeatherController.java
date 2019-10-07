package Controller;

import Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    private void setWeatherService(WeatherService weatherService){this.weatherService = weatherService;}


}
