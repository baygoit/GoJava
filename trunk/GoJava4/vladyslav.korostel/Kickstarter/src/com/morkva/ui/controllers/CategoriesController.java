package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.views.CategoriesView;
import com.morkva.ui.views.IView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoriesController implements IController{
    IView view;
    Model model;
    Printer printer;

    public CategoriesController(Model model, Reader reader, Printer printer) {
        this.model = model;
        this.printer = printer;
        this.view = new CategoriesView(model, printer, reader);
    }

    public void showView() {
        view.showContent();
    }


    public void readInput() {
        view.readInput();
    }
}
