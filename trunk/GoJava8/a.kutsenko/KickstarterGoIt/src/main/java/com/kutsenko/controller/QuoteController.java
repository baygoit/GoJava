package com.kutsenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kutsenko.dao.QuoteDao;

@Controller
public class QuoteController {
	
	@Autowired
	private QuoteDao quoteDao;
	
	@RequestMapping(value = "/quote", method = RequestMethod.GET)
    public ModelAndView showQuote() {
        ModelAndView modelAndView = new ModelAndView("quote");
        modelAndView.addObject("quote", quoteDao.getRandom());
        return modelAndView;
    }
}
