package com.shcherbak.controllers;

import com.shcherbak.model.Apartment;
import com.shcherbak.processing.ApartmentJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class ApartmentController {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");
    private ApartmentJDBC apartmentJDBC = (ApartmentJDBC)context.getBean("apartmentJDBC");

    @RequestMapping("apartment")
    public String apartment(@RequestParam("userID") Integer owner, Model model) {
        model.addAttribute("message", "Enter login or email please");
        model.addAttribute("userID", owner);
        return "apartment";
    }

    @RequestMapping(value = "registerApartment", method = RequestMethod.POST)
    public String registerApartment( @RequestParam("userID") Integer owner, @RequestParam("city") String city,
                                     @RequestParam("street") String street, @RequestParam("house") Integer house,
                                     @RequestParam("room") Integer room, @RequestParam("rent") String rent,
                                     @RequestParam("comments") String comments, Model model) {

        apartmentJDBC.create(owner, city, street, house,
                room, rent, new Date(), comments);
        model.addAttribute("message", "Would you like register another apartment?");
        model.addAttribute("userID", owner);
        model.addAttribute("type", "host");
        return "apartment";
    }

    @RequestMapping(value = "showMyApartments", method = RequestMethod.POST)
    public String showMyApartments( @RequestParam("userID") String owner, Model model) {
        //System.out.println("showMyApartments  " + owner);
        String value = "\'" + owner + "\'";
        List<Apartment> apartments = apartmentJDBC.getApartmentByField("owner", value);
        model.addAttribute("apartments", apartments);
        model.addAttribute("message", "Your available apartments");
        model.addAttribute("userID", owner);
        model.addAttribute("type", "host");
        /*for (Apartment ap: apartments) {
            System.out.println(ap);
        }*/
        return "apartments";
    }

    @RequestMapping(value = "getApartments", method = RequestMethod.POST)
    public String getApartments( @RequestParam("city") String city, Model model) {
        String value = "\'" + city + "\'";
        List<Apartment> apartments = apartmentJDBC.getApartmentByField("city", value);
        model.addAttribute("apartments", apartments);
        model.addAttribute("message", "available in " + city + " apartments");
        //model.addAttribute("userID", owner);
        //model.addAttribute("type", "host");

        return "apartments";
    }

    @RequestMapping(value = "deleteApartment", method = RequestMethod.POST)
    public String deleteMyApartment( @RequestParam("apartmentID") Integer apartmentID,
                                     @RequestParam("userID") String owner, Model model) {
        apartmentJDBC.delete(apartmentID);
        return showMyApartments(owner, model);
    }
}
