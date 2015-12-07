package com.airbnb.Controllers;

import com.airbnb.Search;
import com.airbnb.model.Apartment;
import com.airbnb.services.ApartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by Игорь on 30.11.2015.
 */
@Controller
@SessionAttributes({"cities", "sign", "login" })
public class ApartamentController {

    @Autowired
    ServletContext context;

    @Autowired
    ApartamentService apartamentService;

    @PostConstruct
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init() {
        Set<String> cities = apartamentService.getCitiesSet();
        context.setAttribute("cities", cities);
        context.setAttribute("sign", "Sign in");
        context.setAttribute("login", "login");
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView getMainPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("sign", "Sign in");
        modelAndView.addObject("login", "login");
        session.invalidate();
        return modelAndView;
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ModelAndView getApartaments(@RequestParam("city") String city) {
        try {
            List<Apartment> apartments = apartamentService.getAllApartments();
            Search search = new Search();
            List<Apartment> searchedApartments = search.searchByCity(apartments, city);
            return new ModelAndView("/WEB-INF/view/room", "apartaments", searchedApartments) ;
        } catch (IllegalStateException e) {
            return new ModelAndView("/WEB-INF/view/Error");
        }
    }
}
