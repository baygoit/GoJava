package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.logic.Printer;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.CategoriesController;

import java.util.List;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoriesView implements IView{
    Model model;
    Printer printer;

    public CategoriesView(Model model, Printer printer) {
        this.model = model;
        this.printer = printer;
    }

    public void show() {
        for (Category category : model.getCategories()) {
            printer.print(category.getId() + ": " + category.getName() + "\n");
        }
        showFooter();
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from program\n");
        printer.print("----------------------------\n");
    }
}
