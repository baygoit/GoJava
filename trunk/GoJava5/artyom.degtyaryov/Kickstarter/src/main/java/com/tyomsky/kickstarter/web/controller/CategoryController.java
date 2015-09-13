package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.dao.CategoryDAO;
import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "category", method = RequestMethod.GET)
public class CategoryController {

    @Autowired
    ProjectDAO projectDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping(value = "/{categoryId}")
    public ModelAndView getCategory(@PathVariable(value = "categoryId") int categoryId) {
        Category category = categoryDAO.get(categoryId);
        List<Project> projects = projectDAO.getByCategoryId(categoryId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        modelAndView.addObject("category", category);
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

}
