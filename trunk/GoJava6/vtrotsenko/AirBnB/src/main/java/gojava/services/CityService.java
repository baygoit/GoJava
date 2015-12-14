package gojava.services;

import gojava.dao.CityDAO;
import gojava.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by root on 13.12.15.
 */
@Component
public class CityService {

    @Autowired
    CityDAO cityDAO;

    public List<City> getAllCities() {
        List<City> cities = cityDAO.findAll();
        return cities;
    }

}
