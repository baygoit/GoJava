package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.model.CategoryRepository;

/**
 * Created by vladyslav on 02.05.15.
 */
public class CategoryRepositoryImpl implements CategoryRepository {

    private Category[] categories;

    public CategoryRepositoryImpl(Category[] categories) {
        this.categories = categories;
    }

    @Override
    public Category[] getAllCategories() {
        assert categories.length > 0;
        return categories;
    }

}
