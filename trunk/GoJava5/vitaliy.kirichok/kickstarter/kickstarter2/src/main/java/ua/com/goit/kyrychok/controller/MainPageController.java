package ua.com.goit.kyrychok.controller;

import ua.com.goit.kyrychok.dao.CategoryDao;
import ua.com.goit.kyrychok.domain.Category;
import ua.com.goit.kyrychok.model.MainModel;

import java.util.HashMap;

public class MainPageController {
    private CategoryDao categoryDao;

    public MainPageController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public MainModel getModel() {
        MainModel result = new MainModel();
        result.welcomeMessage = categoryDao.getWelcomeMessage();
        result.categories = new HashMap<>();
        for (Category category : categoryDao.fetch()) {
            result.categories.put(category.getId(), category.getName());
        }
        return result;
    }
}
