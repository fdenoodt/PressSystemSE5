package Service;

import DAO.WeatherRepository;
import Domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository weatherRepository;

    @Autowired
    private void setWeatherRepository(WeatherRepository weatherRepository){this.weatherRepository = weatherRepository;}

    @Override
    public List<Weather> listAllWeather() {
        return null;
    }
}
