package com.airbnb.Controllers;

import com.airbnb.services.AdminService;
import com.airbnb.services.ApartamentService;
import com.airbnb.services.ReservationDatesService;
import com.airbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.airbnb.listeners.PersistenceAppListener;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Игорь on 30.11.2015.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    ApartamentService apartamentService;

    @Autowired
    ReservationDatesService reservationDatesService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getInstances(@RequestParam("show") String show) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/admin");
        if (show.equals("users")) {
            modelAndView.addObject("users", userService.getAllUsers());
        } else if (show.equals("apartaments")) {
            modelAndView.addObject("apartaments", apartamentService.getAllApartments());
        } else {
            modelAndView.addObject("reservation_dates", reservationDatesService.getAllReservationDates());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam("id") int userId) {
        return new ModelAndView("/WEB-INF/view/user", "user", userService.getById(userId));
    }
}
