package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.CommandType;
import com.morkva.ui.Model;
import com.morkva.ui.views.CategoriesView;
import com.morkva.ui.views.IView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoriesController implements IController{
    IView view;
    Model model;
    Reader reader;
    Printer printer;

    public CategoriesController(Model model, Reader reader, Printer printer) {
        this.model = model;
        this.reader = reader;
        this.printer = printer;
        this.view = new CategoriesView(model, printer);
    }

    public void showView() {
        view.show();
    }


    public CommandType readInput() {
        CommandType command = CommandType.DEFAULT_COMMAND;
        int keyCode = reader.readUserInput();
        if (keyCode == 0) {
            command = CommandType.EXIT;
        } else if (keyCode > 0 && keyCode <= model.getCategories().size()) {
            model.setCurrentCategory(model.getCategoryById(keyCode));
            command = CommandType.SHOW_CATEGORY_VIEW;
        }
        return command;
    }
}
