package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.QuoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class QuoteController {
    public static final String APPLICATION_TITLE = "Kickstarter";
    private static final String QUOTE = "quote";

    @Autowired
    QuoteDao quoteDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showRandomQuota(Map<String, Object> model) {
        model.put("title", APPLICATION_TITLE);
        model.put(QUOTE, quoteDao.getRandomQuota());
        return QUOTE;
    }

}
