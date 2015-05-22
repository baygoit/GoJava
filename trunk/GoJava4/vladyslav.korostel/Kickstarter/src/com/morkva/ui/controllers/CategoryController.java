package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.CommandType;
import com.morkva.ui.Model;
import com.morkva.ui.views.CategoryView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoryController {

    private Model model;
    private CategoryView view;
    private Reader reader;

    public CategoryController(Printer printer, Model model, Reader reader) {
        this.reader = reader;
        this.view = new CategoryView(model, printer);
        this.model = model;
        this.model.setCurrentCategory(model.getCurrentCategory());
    }

    public void showView() {
        view.show();
    }

    public CommandType readInput() {
        CommandType command = CommandType.DEFAULT_COMMAND;
        int keyCode = reader.readUserInput();
        if (keyCode == 0) {
            command = CommandType.EXIT_FROM_CATEGORY;
        } else if (keyCode > 0 && keyCode <= model.getCurrentCategory().getProjects().size()) {
            model.setCurrentProject(model.getProjectByIdFromCurrentCategory(keyCode));
            command = CommandType.SHOW_PROJECT_VIEW;
        }
        return command;
    }

}
