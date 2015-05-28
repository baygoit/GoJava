package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewType;

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
        for (Project project : category.getProjects()) {
            printer.print(project.getId() + ": " + project.getShortInfo());
        }

        showFooter();
    }

    @Override
    public ViewType readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                return ViewType.CATEGORIES_PAGE;
            } else if (keyCode > 0) {
                model.setCurrentProject(model.getProjectByIdFromCurrentCategory(keyCode));
                return ViewType.PROJECT_PAGE;
            }
        }
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from category\n");
        printer.print("----------------------------\n");
    }
}
