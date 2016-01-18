package com.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kickstarter.dao.Impl.CategoryDaoImpl;
import com.kickstarter.dao.Impl.QuoteDaoImpl;

@Controller
@RequestMapping({"/categories", "/"})
public class CategoryController {

    @Autowired
    private QuoteDaoImpl quoteDao;
    @Autowired
    private CategoryDaoImpl categoryDao;

    public ModelAndView allCategories() {
        ModelAndView modelAndView = new ModelAndView("AllCategories");
        modelAndView.addObject("quote", quoteDao.get());
        modelAndView.addObject("categoryList", categoryDao.getAll());
        return modelAndView;
    }

}
