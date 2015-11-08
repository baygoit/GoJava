package com.project.service;

import com.project.dao.CategoryDao;
import com.project.model.Category;
import java.util.List;

public class CategoryServiceImplementation implements CategoryService {
  private final CategoryDao categoryDao;

  public CategoryServiceImplementation(CategoryDao categoryDao) {
    this.categoryDao = categoryDao;
  }

  @Override
  public List<Category> findAll() {
    return null;
  }
}
