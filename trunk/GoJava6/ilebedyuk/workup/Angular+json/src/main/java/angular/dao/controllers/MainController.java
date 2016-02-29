package angular.dao.controllers;

import angular.dao.dao.ApartamentDao;
import angular.dao.dao.ReservationDao;
import angular.dao.dao.UserDao;
import angular.dao.model.Apartament;
import angular.dao.model.Reservation;
import angular.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Игорь on 16.12.2015.
 */
@RestController
public class MainController {

    @Autowired
    UserDao userDao;
    @Autowired
    ApartamentDao apartamentDao;
    @Autowired
    ReservationDao reservationDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return userDao.getUserList();
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> getAllReservations(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return reservationDao.getReservationDateList();
    }

    @RequestMapping(value = "/apartaments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Apartament> getAllApartaments(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return apartamentDao.getApartmentList();
    }
}
