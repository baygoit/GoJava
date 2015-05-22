package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.CategoryController;
import com.morkva.ui.controllers.ProjectController;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectView implements IView{

    Model model;
    Printer printer;

    public ProjectView(Model model, Printer printer) {
        this.model = model;
        this.printer = printer;
    }

    public void show() {
        Project project = model.getCurrentProject();
        printer.print(project.getFullInfo());
        showFooter();
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from project\n");
        printer.print("----------------------------\n");
    }
}
