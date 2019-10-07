package Service;

import Domain.Weather;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherService {
    List<Weather> listAllWeather();
}
