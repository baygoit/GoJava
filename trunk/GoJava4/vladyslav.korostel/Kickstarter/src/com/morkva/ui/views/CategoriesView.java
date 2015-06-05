package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.CategoryController;
import com.morkva.ui.controllers.IController;

/**
 * Created by vladyslav on 22.05.15.
 */
public class CategoriesView implements IView{
    Model model;
    Printer printer;
    Reader reader;

    public CategoriesView(Model model, Printer printer, Reader reader) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
    }

    public void showContent() {
        for (Category category : model.getCategories()) {
            printer.print(category.getId() + ": " + category.getName() + "\n");
        }
        showFooter();
    }

    @Override
    public IController readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                System.exit(0);
            } else if (keyCode > 0 && keyCode <= model.getCategories().size()) {
                model.setCurrentCategory(model.getCategoryById(keyCode));
                return new CategoryController(printer, model, reader);
            }
        }
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from program\n");
        printer.print("----------------------------\n");
    }
}
