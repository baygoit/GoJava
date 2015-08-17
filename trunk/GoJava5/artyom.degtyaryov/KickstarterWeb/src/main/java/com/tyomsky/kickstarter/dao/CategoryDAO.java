package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.model.Category;

import java.util.List;

public interface CategoryDAO {

    Category get(int id);

    List<Category> getAll();
}
