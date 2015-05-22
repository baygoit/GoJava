package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.ui.Model;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoryView implements IView {

    Model model;
    Printer printer;

    public CategoryView(Model model, Printer printer) {
        this.model = model;
        this.printer = printer;
    }

    public void show() {
        Category category = model.getCurrentCategory();
        printer.print("Select project: ");
        for (Project project : category.getProjects()) {
            printer.print(project.getId() + ": " + project.getShortInfo());
        }

        showFooter();
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from category\n");
        printer.print("----------------------------\n");
    }
}
