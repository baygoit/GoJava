package services;

import dao.hibernate.CityDao;
import entity.City;
import entity.enums.CityList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class CityService {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

    CityDao cityDao = (CityDao) context.getBean("cityDao");

    public void createCity(City city){
        cityDao.create(city);
    }

    public City readCityById(int Id){
        return cityDao.read(Id);
    }

    public List<CityList> getAllCities() {
        return Arrays.asList(CityList.values());
    }




}
