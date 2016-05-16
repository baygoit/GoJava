package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class CategoryController {
    private static final String CATEGORIES = "categories";
    private static final String CATEGORY = "category";
    private static final String SC_NOT_FOUND = "404";

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProjectDao projectDao;

    @RequestMapping(value = "/" + CATEGORIES, method = RequestMethod.GET)
    public String showCategories(Map<String, Object> model) {
        model.put("title", "Categories");
        model.put(CATEGORIES, categoryDao.getAll());
        return CATEGORIES;
    }

    @RequestMapping(value = "/" + CATEGORY + "/{id}", method = RequestMethod.GET)
    public String showCategory(@PathVariable Integer id, Map<String, Object> model) {
        if (!categoryDao.isCategoryExist(id)) {
            return SC_NOT_FOUND;
        }
        Category category = categoryDao.findById(id);
        model.put("title", category.getName());
        model.put("category", category);
        model.put("projects", projectDao.findByCategory(category));
        return CATEGORY;
    }
}
