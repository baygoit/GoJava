package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.model.CategoryModel;
import com.tyomsky.kickstarter.mvc.view.CategoryView;

public class CategoryController {

    CategoryModel model;
    CategoryView view;

    public CategoryController(CategoryView view, CategoryModel model) {
        this.view = view;
        this.model = model;
    }

    public boolean showModel(int index) {
        boolean isShown = false;
        try {
            model.update(index);
            view.show(model);
            isShown = true;
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            isShown = false;
        }
        return isShown;
    }

}
