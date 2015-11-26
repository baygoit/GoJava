package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.City;
import com.donishchenko.airbnb.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private SearchService searchService;

    @PostConstruct
    private void init() {
        List<City> availableCities = searchService.getAllCities();
        servletContext.setAttribute("availableCities", availableCities);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getSearch() {
        return "search";
    }

    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public String searchByCity(@PathVariable String city, Model model) {
        //TODO search
        List<Apartment> apartments = searchService.getAllApartmentsByCity(city);
        model.addAttribute("apartments", apartments);

        return "/search";
    }
}
