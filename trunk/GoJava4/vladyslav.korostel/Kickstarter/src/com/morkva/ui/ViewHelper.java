package com.morkva.ui;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.controllers.CategoriesController;
import com.morkva.ui.controllers.CategoryController;
import com.morkva.ui.controllers.IController;
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
                IController categoriesController = new CategoriesController(model, reader, printer);
                categoriesController.showView();
                ViewResolver.getInstance().setNextView(categoriesController.readInput());
                break;
            case CATEGORY_PAGE:
                IController categoryController = new CategoryController(printer, model, reader);
                categoryController.showView();
                ViewResolver.getInstance().setNextView(categoryController.readInput());
                break;
            case PROJECT_PAGE:
                IController projectController = new ProjectController(printer, model, reader);
                projectController.showView();
                ViewResolver.getInstance().setNextView(projectController.readInput());
        }
    }

    public void runCommand() {
        while (true) {
            ViewType viewType = ViewResolver.getInstance().getNextView();
            switch (viewType) {
                case CATEGORIES_PAGE:
                    showView(ViewType.CATEGORIES_PAGE);
                    break;
                case CATEGORY_PAGE:
                    showView(ViewType.CATEGORY_PAGE);
                    break;
                case PROJECT_PAGE:
                    showView(ViewType.PROJECT_PAGE);
                    break;
            }
        }
    }
}
