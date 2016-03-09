package com.shcherbak.controllers;


import com.shcherbak.model.Apartment;
import com.shcherbak.processing.ApartmentJDBC;
import com.shcherbak.processing.ReservationJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Controller
public class ReservationController {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");
    private ReservationJDBC reservationJDBC = (ReservationJDBC)context.getBean("reservationJDBC");
    private ApartmentJDBC apartmentJDBC = (ApartmentJDBC)context.getBean("apartmentJDBC");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Date start, end;
    private static int count = 0;


    private boolean dateParse( String startDate, String endDate) {
        try {
            start = sdf.parse(startDate);
            end = sdf.parse(endDate);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    @RequestMapping(value = "reservation", method = RequestMethod.POST)
    public String reservation(@RequestParam("userID") Integer userID, Model model) {
        model.addAttribute("cities", apartmentJDBC.getCities());
        model.addAttribute("message", "choose city");
        model.addAttribute("userID", userID);
        return "reservation";
    }


    @RequestMapping(value = "registerReservation", method = RequestMethod.POST)
    public String registerReservation( @RequestParam("apartmentID") Integer apartmentID, @RequestParam("userID") Integer clientID,
                                     @RequestParam("start") String startDate, @RequestParam("end") String endDate,
                                     @RequestParam("comments") String comments, Model model) {

        reservationJDBC.create(apartmentID, clientID, start, end, new Date(), comments);

        return reservation(clientID, model);
    }

    @RequestMapping(value = "searchApartments", method = RequestMethod.POST)
    public String searchApartments( @RequestParam("city") String city, @RequestParam("start") String startDate,
                                    @RequestParam("end") String endDate, @RequestParam("userID") Integer clientID,
                                    Model model) {
        /*System.out.println(city);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(clientID);*/

        List<Apartment> apartments;
        if (dateParse( startDate, endDate)) {
            String value = "\'" + city + "\'";
            apartments = apartmentJDBC.getApartmentByField("city", value);
            List<Integer> apartmentsID = reservationJDBC.getReservationsByDates(start, end);
            ListIterator<Apartment> aIt = apartments.listIterator();
            while (aIt.hasNext()) {
                Apartment apartment = aIt.next();
                for (Integer id: apartmentsID) {
                    if (apartment.getApartmentID() == id) {
                        aIt.remove();
                    }
                }
            }
            model.addAttribute("apartments", apartments);
            if (apartments != null) {
                model.addAttribute("message", "available in " + city + " apartments");
            } else {
                model.addAttribute("message", "there ara no available in " + city + " apartments");
            }
        } else {
            model.addAttribute("message", "dates are not correct");
        }
        model.addAttribute("userID", clientID);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "reservation";
    }
}
