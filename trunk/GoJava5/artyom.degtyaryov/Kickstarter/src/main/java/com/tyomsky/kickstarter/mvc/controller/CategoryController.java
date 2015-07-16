package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.mvc.model.CategoryPageModel;
import com.tyomsky.kickstarter.mvc.view.CategoryPageView;

public class CategoryController extends AbstractController<CategoryPageModel, CategoryPageView> implements InputListener{

    public CategoryController(CategoryPageModel model, CategoryPageView view) {
        super(model, view);
    }

    @Override
    public void onInput(int... input) {
        if (!(input.length < 1)) {
            int projectId = input[0];
            model.update(projectId);
        }
    }
}
