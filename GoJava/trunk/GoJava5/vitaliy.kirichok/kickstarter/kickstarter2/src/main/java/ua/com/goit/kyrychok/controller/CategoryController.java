package ua.com.goit.kyrychok.controller;

import ua.com.goit.kyrychok.dao.CategoryDao;
import ua.com.goit.kyrychok.domain.Category;

import java.util.List;

public class CategoryController {
    private CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getCategories() {
        return categoryDao.fetch();
    }

    public String getWelcomeMessage() {
        return categoryDao.getWelcomeMessage();
    }

    public Category get(int id) {
        return categoryDao.get(id);
    }
}
