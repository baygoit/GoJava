package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.model.Model;
import com.morkva.ui.views.CategoryView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoryController implements IController{

    private Model model;
    private CategoryView view;

    public CategoryController(Printer printer, Model model, Reader reader) {
        this.view = new CategoryView(model, printer, reader);
        this.model = model;
        this.model.setCurrentCategory(model.getCurrentCategory());
    }

    public void showView() {
        view.showContent();
    }

    public void readInput() {
        view.readInput();
    }

}
