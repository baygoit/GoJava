package com.morkva.ui;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.model.Repository;

import java.util.List;

/**
 * Created by vladyslav on 20.05.15.
 */
public class CategoriesPage {

    Printer printer;
    Reader reader;
    Repository<Category> categoryRepository;

    public CategoriesPage(Printer printer, Reader reader, Repository<Category> categoryRepository) {
        this.printer = printer;
        this.reader = reader;
        this.categoryRepository = categoryRepository;
    }

    public void showCategories() {
        printer.print("Select category: \n");
        for (int i = 0; i < categoryRepository.size(); i++) {
            printer.print(i + 1 + ": " + categoryRepository.getByIndex(i).getName() + "\n");
        }
    }

    public void showMenu(Category category) {
        List<Project> projectsOfCurrentCategory = category.getProjects();
        while (true) {

            new CategoryPage(printer, category).show();

            printer.print("\n");
            printer.print("Press 0 for exit from this category \n");
            printer.print("--------------------------------------------\n");

            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                break;
            } else {
                if (keyCode > 0 && keyCode <= projectsOfCurrentCategory.size()) {
                    Project selectedProject = projectsOfCurrentCategory.get(keyCode-1);
                    new ProjectPage(printer, reader, selectedProject).showProjectMenu();
                } else {
                    printer.print("Project with №" + keyCode + " does not exist");
                }
            }
        } //end projectsListLoop
    }
}
