package services;

import entity.Home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SearchService {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

    ReservationService resService = (ReservationService)context.getBean("reservationService");

    public List<Home> getHomesByCity(String cityName) {
        List<Home> result;
        return  null;
    }



}
