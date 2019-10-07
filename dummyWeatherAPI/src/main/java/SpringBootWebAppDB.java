import DAO.WeatherRepository;
import Domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringBootWebAppDB implements ApplicationListener<ContextRefreshedEvent> {
    private WeatherRepository weatherRepository;

    @Autowired
    private void setWeatherRepository(WeatherRepository weatherRepository){this.weatherRepository = weatherRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Weather weather =  new Weather(125,7,32,10,new Date("2018-05-20"),new Date("2018-05-20"));
        weatherRepository.save(weather);
    }
}
