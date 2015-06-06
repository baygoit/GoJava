package com.morkva.ui.views;

import com.morkva.entities.Category;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewResolver;
import com.morkva.ui.controllers.CategoryController;

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
    public void readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                System.exit(0);
            } else if (keyCode > 0 && keyCode <= model.getCategories().size()) {
                model.setCurrentCategory(model.getCategoryById(keyCode));
                ViewResolver.getInstance().setNextView(new CategoryController(printer, model, reader));
                break;
            }
        }
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("Press 0 for exit from program\n");
        printer.print("----------------------------\n");
    }
}
