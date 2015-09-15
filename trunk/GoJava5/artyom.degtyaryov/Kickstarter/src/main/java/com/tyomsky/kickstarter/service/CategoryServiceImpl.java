package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.dao.CategoryDAO;
import com.tyomsky.kickstarter.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        List<Category> categories;
        categories = categoryDAO.getAll();
        return categories;
    }

}
