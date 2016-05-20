package ua.dborisenko.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.domain.Category;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showCategories() {
        ModelAndView mav = new ModelAndView("categories");
        mav.addObject("categories", categoryDao.getAll());
        return mav;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ModelAndView showCategory(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("category");
        try {
            Category category = categoryDao.getWithProjects(id);
            modelAndView.addObject("category", category);
            return modelAndView;
        } catch (EmptyResultDataAccessException e) {
            modelAndView.setViewName("error404");
            modelAndView.addObject("errorText", "error.categoryNotFound");
            return modelAndView;
        }
    }
}
