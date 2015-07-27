package goit5.nikfisher.kickstarter.menu;


import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.ConsoleIO;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;

import java.util.List;

public class CategoryMenu {

    private String SPACE = " ";
    private ConsoleInterfaceIO io;
    private Projects projects;
    private InMemoryCategories categories;

    public CategoryMenu(ConsoleInterfaceIO io, Projects projects, Categories categories) {
        this.io = io;
        this.categories = (InMemoryCategories) categories;
		this.projects = projects;
    }

    public void categoryMenu() {
        while (true){

            askCategory();

            int categoryIndex = io.consoleScanInt();

            if (categoryIndex == 0){
                break;
            }
            Category category = chooseCategory(categoryIndex);

            if (category == null){
                continue;
            }

            List<Project> foundProjects = projects.getProjects(category);
            printProjects(foundProjects);

            ProjectsMenu projectsMenu = new ProjectsMenu(new ConsoleIO());
            projectsMenu.projectsMenu(foundProjects);
        }
    }

    private Category chooseCategory(int categoryIndex) {

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
        io.println(String.valueOf(categories.getCategories()));
    }

    private void printProjects(List<Project> foundProjects) {

        for (int i = 0; i < foundProjects.size(); i++) {
            Project project = foundProjects.get(i);
            io.print((i + 1) + ") ");
            printProject(project);
        }
    }

    //TODO
    private void printProject(Project project) {

		io.println("Project name: " + project.getName());
		io.println("Description: " + project.getDescription());
		io.println("Need collected: " + project.getAmount() + "$");
		io.println("Already collected: " + project.getExist() + "$");
		io.println("Days remaining: " + project.getDays());
		io.println("---------------------------------------");
		io.println(SPACE);
	}
}
