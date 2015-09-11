package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.dao.CategoryDAO;
import com.tyomsky.kickstarter.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("quote", quoteService.getRandomQuote());
        model.addAttribute("categories", categoryDAO.getAll());
        return "mainPage";
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void setQuoteService(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

}