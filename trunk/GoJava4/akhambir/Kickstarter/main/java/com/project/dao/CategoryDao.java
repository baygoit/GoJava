package com.project.dao;

import com.project.model.Category;

import java.util.List;

public interface CategoryDao {
  List<Category> findAll();
}
