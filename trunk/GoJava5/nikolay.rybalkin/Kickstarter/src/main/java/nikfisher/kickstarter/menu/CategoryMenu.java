package nikfisher.kickstarter.menu;


import nikfisher.kickstarter.dao.Categories;
import nikfisher.kickstarter.dao.Projects;
import nikfisher.kickstarter.model.Category;
import nikfisher.kickstarter.model.Project;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;

import java.util.List;

public class CategoryMenu {

    final private String SPACE = " ";
    final private ConsoleInterfaceIO IO;
    final private Projects PROJECTS;
    final private Categories CATEGORIES;

    public CategoryMenu(ConsoleInterfaceIO io, Projects projects, Categories categories) {
        this.IO = io;
        this.CATEGORIES = categories;
        this.PROJECTS = projects;
    }

    public void categoryMenu() {
        while (true) {

            askCategory();

            int categoryIndex = IO.consoleScanInt();

            if (categoryIndex == 0) {
                break;
            }
            Category category = chooseCategory(categoryIndex);

            if (category == null) {
                continue;
            }

            List<Project> foundProjects = PROJECTS.getProjects(category);
            printProjects(foundProjects);

            ProjectsMenu projectsMenu = new ProjectsMenu(IO);
            projectsMenu.projectsMenu(foundProjects);
        }
    }

    private Category chooseCategory(int categoryIndex) {

        if (categoryIndex <= 0 || CATEGORIES.size() < categoryIndex) {
            IO.println("Not true index: " + categoryIndex);
            return null;
        }

        Category category = CATEGORIES.get(categoryIndex);
        IO.println("You selected category: " + category.getName());
        return category;
    }

    private void askCategory() {

        IO.println(SPACE);
        IO.println("Select category (or 0 to exit): ");
        IO.println(String.valueOf(CATEGORIES.getCategories()));
    }

    private void printProjects(List<Project> foundProjects) {

        for (int i = 0; i < foundProjects.size(); i++) {
            Project project = foundProjects.get(i);
            IO.print((i + 1) + ") ");
            printProject(project);
        }
    }

    //TODO duplicated method
    private void printProject(Project project) {

        IO.println("Project name: " + project.getName());
        IO.println("Description: " + project.getDescription());
        IO.println("Need collected: " + project.getAmount() + "$");
        IO.println("Already collected: " + project.getExist() + "$");
        IO.println("Days remaining: " + project.getDays());
        IO.println("---------------------------------------");
        IO.println(SPACE);
    }
}
