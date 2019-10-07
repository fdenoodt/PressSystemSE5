package DAO;

import Domain.Weather;
import org.springframework.data.repository.CrudRepository;


public interface WeatherRepository extends CrudRepository<Weather, Integer> {
}
