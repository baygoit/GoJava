package com.morkva.ui;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.controllers.CategoriesController;
import com.morkva.ui.controllers.CategoryController;
import com.morkva.ui.controllers.ProjectController;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ViewHelper {

    Model model;
    Printer printer;
    Reader reader;

    public ViewHelper(Model model, Printer printer, Reader reader) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
    }

    public void showView(ViewType viewType) {
        switch (viewType) {
            case CATEGORIES_PAGE:
                CategoriesController categoriesController = new CategoriesController(model, reader, printer);
                categoriesController.showView();
                sendCommand(categoriesController.readInput());
                break;
            case CATEGORY_PAGE:
                CategoryController categoryController = new CategoryController(printer, model, reader);
                categoryController.showView();
                sendCommand(categoryController.readInput());
                break;
            case PROJECT_PAGE:
                ProjectController projectController = new ProjectController(printer, model, reader);
                projectController.showView();
                sendCommand(projectController.readInput());
        }
    }

    public void sendCommand(CommandType command) {
        switch (command) {
            case SHOW_CATEGORIES_VIEW:
                showView(ViewType.CATEGORIES_PAGE);
                break;
            case SHOW_CATEGORY_VIEW:
                showView(ViewType.CATEGORY_PAGE);
                break;
            case SHOW_PROJECT_VIEW:
                showView(ViewType.PROJECT_PAGE);
                break;
            case DEFAULT_COMMAND:
                System.err.println("DEFAULT_COMMAND");
                break;
            case EXIT_FROM_CATEGORY:
                showView(ViewType.CATEGORIES_PAGE);
                break;
            case EXIT_FROM_PROJECT:
                showView(ViewType.CATEGORY_PAGE);
            case EXIT:
                System.exit(0);
        }
    }
}
