package nikfisher.kickstarter.view;

import nikfisher.kickstarter.dao.Categories;
import nikfisher.kickstarter.dao.InMemoryCategories;
import nikfisher.kickstarter.dao.InMemoryProjects;
import nikfisher.kickstarter.dao.Projects;
import nikfisher.kickstarter.menu.CategoryMenu;
import nikfisher.kickstarter.model.Category;
import nikfisher.kickstarter.model.Project;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;

@SuppressWarnings("deprecation")
public class View {

    final private ConsoleInterfaceIO IO;
    private Projects projects;
    private Categories categories;

    public View(ConsoleInterfaceIO io, Projects projects, Categories categories) {
        this.IO = io;
        this.categories = categories;
        this.projects = projects;
    }


    public void createCategories() {

        Category category1 = new Category("Game");
        Category category2 = new Category("Design");
        Category category3 = new Category("NoProjects");

		categories = new InMemoryCategories();
//        categories = new InFileCategories("categories.txt");
//        categories = new CategoriesDAO();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        Project project1 = new Project("Game \"Popcorn\"", 10000, 0, 10, "Interesting game");
        Project project2 = new Project("Design \"Popcorn\"", 10000, 0, 10, "Innovation design");

        project1.setCategory(category1);
        project2.setCategory(category2);

//        projects = new InFileProjects("projects.txt");
        projects = new InMemoryProjects();
        projects.add(project1);
        projects.add(project2);

        project1.setHistory("History this project");
        project2.setHistory("History this project");

        project1.setVideo("https://www.youtube.com");
        project2.setVideo("https://www.youtube.com");

        project1.setQuestion("No one has asked the question.");
        project2.setQuestion("No one has asked the question.");

        project1.setAnswer("Still no one answered");
        project2.setAnswer("Still no one answered");


        CategoryMenu categoryMenu = new CategoryMenu(IO, projects, categories);
        categoryMenu.categoryMenu();
    }
}
