package com.tyomsky.kickstarter.controller;

import com.tyomsky.kickstarter.model.CategoryModel;
import com.tyomsky.kickstarter.view.CategoryView;

public class CategoryController extends AbstractController{

    CategoryModel model;

    public CategoryController(CategoryView view, CategoryModel model) {
        super(view);
        this.model = model;
    }

    @Override
    public void showModel(int...parameters) {
        model.update(parameters[0]-1);
        view.show();
    }

    @Override
    public void processInput(int input) {
        AbstractController child = getChild();
        AbstractController parent = getParent();
        if (currentIndex == 0) {
            if (input == 0) {
                parent.showModel(0);
            } else {
                currentIndex = input;
                child.showModel(parent.getCurrentIndex(), input); //Category index + project index
            }
        } else {
            child.processInput(input);
        }
    }
}
