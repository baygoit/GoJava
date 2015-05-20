package com.morkva.ui;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;

import java.util.List;

/**
 * Created by vladyslav on 20.05.15.
 */
public class CategoryPage {

    Printer printer;
    Category category;

    public CategoryPage(Printer printer, Category category) {
        this.printer = printer;
        this.category = category;
    }

    public void show() {
        printer.print("Category: " + category.getName()+ "\n");
        printer.print("  Projects: \n");
        List<Project> currentCategoryProjects = category.getProjects();
        for (int i = 0; i < currentCategoryProjects.size(); i++) {
            System.out.print("  " + (i + 1) + ": ");
            printer.print(currentCategoryProjects.get(i).getShortInfo() + "\n");
        }
    }
}
