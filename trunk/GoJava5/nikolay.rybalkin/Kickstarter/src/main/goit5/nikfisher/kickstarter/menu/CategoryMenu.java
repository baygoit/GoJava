package goit5.nikfisher.kickstarter.menu;


import goit5.nikfisher.kickstarter.model.Categories;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.Projects;
import goit5.nikfisher.kickstarter.streams.InputOutputConsole;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import goit5.nikfisher.kickstarter.model.Category;

import java.util.Arrays;

public class CategoryMenu {

    private String SPACE = " ";
    private InputOutputConsoleInterface io;
    private Projects projects;
    private Categories categories;

    public CategoryMenu(InputOutputConsoleInterface io, Projects projects, Categories categories) {
        this.io = io;
        this.categories = categories;
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

            Project[] foundProjects = projects.getProgects(category);
            printProjects(foundProjects);

            ProjectsMenu projectsMenu = new ProjectsMenu(new InputOutputConsole());
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
        io.println(Arrays.toString(categories.getCategories()));
    }
    private void printProjects(Project[] foundProjects) {

        for (int i = 0; i < foundProjects.length; i++) {
            Project project = foundProjects[i];
            io.print((i + 1) + ") ");
            printProject(project);
        }
    }

    //TODO этот метод используется в двух классах, надо подумать как избежать дублирования
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
