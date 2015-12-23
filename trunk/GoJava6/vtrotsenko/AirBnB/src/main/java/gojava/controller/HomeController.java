package gojava.controller;

import gojava.model.City;
import gojava.model.User;
import gojava.services.CityService;
import gojava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by root on 04.11.15.
 */
@Controller
@SessionAttributes({"name", "lastname", "email", "password", "user", "cities"})
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    CityService cityService;

    @RequestMapping(value = {"/", "home", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@RequestParam("name") String name,
                                     @RequestParam("lastname") String lastname,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password) {

        ModelAndView modelAndView = new ModelAndView();
        User user = new User(name, password, lastname, email);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastname", lastname);
        modelAndView.addObject("email", email);
        modelAndView.addObject("password", password);
        userService.registerUser(user);
        modelAndView.setViewName("/login");
        return modelAndView;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam("email") String email,
                                  @RequestParam("password") String password) {

        ModelAndView modelAndView = new ModelAndView();
        User user = userService.loginUser(email, password);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public ModelAndView getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ModelAndView("/cities", "cities", cities);
    }

}
