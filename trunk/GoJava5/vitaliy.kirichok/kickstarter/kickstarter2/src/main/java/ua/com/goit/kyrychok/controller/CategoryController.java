package ua.com.goit.kyrychok.controller;

import ua.com.goit.kyrychok.dao.CategoryDao;
import ua.com.goit.kyrychok.domain.Category;
import ua.com.goit.kyrychok.domain.Project;
import ua.com.goit.kyrychok.model.CategoryModel;
import ua.com.goit.kyrychok.model.Converter;

import java.util.ArrayList;

public class CategoryController {
    private CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryModel getModel(int id) {
        CategoryModel result = new CategoryModel();
        Category category = categoryDao.get(id);
        result.name = category.getName();
        result.projects = new ArrayList<>();
        for (Project project : category.getProjects()) {
            result.projects.add(Converter.convert(project));
        }
        return result;
    }
}
