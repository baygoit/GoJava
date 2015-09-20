package com.morkva.model;

import com.morkva.entities.Category;

import java.util.List;

/**
 * Created by koros on 15.06.2015.
 */
public interface CategoryRepository {
    List<Category> getAll();

    Category getById(int categoryId);
}
