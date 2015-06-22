package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.model.Model;
import com.morkva.ui.ViewResolver;
import com.morkva.ui.controllers.CategoriesController;
import com.morkva.ui.controllers.ProjectController;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoryView implements IView {

    Model model;
    Printer printer;
    Reader reader;

    public CategoryView(Model model, Printer printer, Reader reader) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
    }

    public void showContent() {
        Category category = model.getCurrentCategory();
        printer.print("Select project: ");
        for (Project project : model.getProjectsFromCategory(model.getCurrentCategory())) {
            printer.print(project.getId() + ": " + project.getShortInfo());
        }

        showFooter();
    }

    @Override
    public void readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                ViewResolver.getInstance().setNextView(new CategoriesController(model, reader, printer));
                break;
            } else if (keyCode > 0) {
                model.setCurrentProject(model.getProjectById(keyCode));
                ViewResolver.getInstance().setNextView(new ProjectController(printer, model, reader));
                break;
            } else {
                printer.print("Wrong code!");
            }
        }
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from category\n");
        printer.print("----------------------------\n");
    }
}
