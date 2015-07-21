package goit5.nikfisher.kickstarter.menu;


import goit5.nikfisher.kickstarter.model.Categories;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.Projects;
import goit5.nikfisher.kickstarter.streams.InputOutputConsole;

import java.util.Arrays;

public class CategoryMenu {

    private String SPACE = " ";
    private InputOutputConsole io;
    private Projects projects;
    private Categories categories;

    public void categoryMenu() {
        while (true){

            askCategory();


            int categoryIndex = io.consoleScanInt();

            if (categoryIndex == 0){
                break;
            }
            Category category = shooseCategory(categoryIndex);

            if (category == null){
                continue;
            }

            Project[] foundProjects = projects.getProgects(category);
            printProjects(foundProjects);

//			projectsMenu(foundProjects);
        }
    }

    private Category shooseCategory(int categoryIndex) {

        if ( categoryIndex <= 0 || categories.size() < categoryIndex){
            io.println("Not true index: " + categoryIndex);
            return null;
        }

        Category category = categories.get(categoryIndex - 1);
        io.println("You selected category: " + category.getName());
        return category;
    }

    private void askCategory() {

        io.println(SPACE);
        io.println("Select category (or 0 to exit): ");
        io.println(Arrays.toString(categories.getCategories()));
    }
    private void printProjects(Project[] foundProjects) {

        for (int i = 0; i < foundProjects.length; i++) {
            Project project = foundProjects[i];
            io.print((i + 1) + ") ");
//            printProject(project);
        }
    }
}
