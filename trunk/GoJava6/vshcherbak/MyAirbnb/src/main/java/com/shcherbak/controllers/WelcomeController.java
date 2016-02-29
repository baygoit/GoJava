package com.shcherbak.controllers;

import com.shcherbak.processing.ApartmentJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");
    private ApartmentJDBC apartmentJDBC = (ApartmentJDBC)context.getBean("apartmentJDBC");

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("message", "Welcome Guest");
        return "index";
    }

    @RequestMapping("register")
    public String register(Model model) {

        model.addAttribute("message", "Enter data please");
        return "user";
    }

    @RequestMapping("login")
    public String login(Model model) {
        model.addAttribute("message", "Enter login or email please");
        return "login";
    }


    @RequestMapping(value = "showCities", method = RequestMethod.POST)
    public ModelAndView listCities() {
        return new ModelAndView("cities", "cities", apartmentJDBC.getCities());
    }


}
