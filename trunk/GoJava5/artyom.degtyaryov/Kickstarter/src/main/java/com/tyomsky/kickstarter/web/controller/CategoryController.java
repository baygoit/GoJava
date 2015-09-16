package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.CategoryService;
import com.tyomsky.kickstarter.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/category", method = RequestMethod.GET)
public class CategoryController {

    ProjectService projectService;
    CategoryService categoryService;

    @RequestMapping(value = "{categoryId}")
    public ModelAndView getCategory(@PathVariable(value = "categoryId") int categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        List<Project> projects = projectService.getProjectsByCategory(category);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        modelAndView.addObject("category", category);
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
