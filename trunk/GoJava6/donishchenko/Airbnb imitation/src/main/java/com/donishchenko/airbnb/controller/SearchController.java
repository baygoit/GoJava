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
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    private List<City> availableCities;

    @PostConstruct
    private void init() {
        availableCities = searchService.getAllCities();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getSearch(Model model) {
        model.addAttribute("availableCities", availableCities);
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
