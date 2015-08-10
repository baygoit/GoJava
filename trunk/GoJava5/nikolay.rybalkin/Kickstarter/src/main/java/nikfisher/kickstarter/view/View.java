package nikfisher.kickstarter.view;

import nikfisher.kickstarter.dao.Categories;
import nikfisher.kickstarter.dao.Projects;
import nikfisher.kickstarter.menu.CategoryMenu;
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
//
//        Project project1 = new Project("Game \"Popcorn\"", 10000, 0, 10, "Interesting game");
//        Project project2 = new Project("Design \"Popcorn\"", 10000, 0, 10, "Innovation design");
//
//        project1.setCategory(category1);
//        project2.setCategory(category2);
//
////        projects = new InFileProjects("projects.txt");
//        projects = new InMemoryProjects();
//        projects.add(project1);
//        projects.add(project2);
//
//        project1.setHistory("History this project");
//        project2.setHistory("History this project");
//
//        project1.setVideo("https://www.youtube.com");
//        project2.setVideo("https://www.youtube.com");
//
//        project1.setQuestion("No one has asked the question.");
//        project2.setQuestion("No one has asked the question.");
//
//        project1.setAnswer("Still no one answered");
//        project2.setAnswer("Still no one answered");


        CategoryMenu categoryMenu = new CategoryMenu(IO, projects, categories);
        categoryMenu.categoryMenu();
    }
}
