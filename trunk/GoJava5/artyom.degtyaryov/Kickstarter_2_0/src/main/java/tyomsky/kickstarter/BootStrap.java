package tyomsky.kickstarter;

import tyomsky.kickstarter.common.DBConnector;
import tyomsky.kickstarter.controller.*;
import tyomsky.kickstarter.dao.*;
import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.ui.ConsoleIO;
import tyomsky.kickstarter.view.TextView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class BootStrap {

    public static void main(String[] args) {

        initializeDB();

        ConsoleIO console = new ConsoleIO();

        CategoriesDAO categories = new CategoriesDAODB();
        categories.add(new Category("Games"));
        categories.add(new Category("Music"));
        categories.add(new Category("Films"));
//        CategoriesDAO categories = new CategoriesDAOFile("file/categories.txt");

        ProjectsDAO projects = new ProjectsDAOMemory();
        Project project1 = new Project("GTA 5", "5-th episode of epic game",
                1_000_000, 365, "http://youtube.com/89a0cdb8", categories.get(0));
        project1.setHistory("we just starter and its nothing to say now! To be continue.");
        project1.setQuestionsAndAnswers("Q: when will you release PC version? \n" +
                "A: Next year.");
        projects.add(project1);
        Project project2 = new Project("StarCraft 2", "continue of epic game",
                2_000_000, 120, "http://youtube.com/21a5c668", categories.get(0));
        projects.add(project2);
        Project project3 = new Project("Kosinka 2", "2-nd part of epic game",
                10_000_000, 1000, "http://youtube.com/160cac48", categories.get(0));
        project3.setHistory("We have collected 100000$ now. We need to collect more to start development.");
        project3.setQuestionsAndAnswers("Q: Will you develop version for Mac and Linux? \n" +
                "A: No. Only Windows");
        project3.setMoneyCollected(100_000);
        projects.add(project3);

        TextView textView = new TextView(console);

        Menu<Category> categoriesMenu = new CategoriesMenu(categories, console, textView);
        Menu<Project> projectsMenu = new ProjectsMenu(projects, console, textView);
        Menu<Integer> projectMenu = new ProjectMenu(projects, console, textView);
        Menu<Integer> paymentMenu = new PaymentMenu(projects, console, textView);
        categoriesMenu.setChildMenu(projectsMenu);
        projectsMenu.setChildMenu(projectMenu);
        projectMenu.setChildMenu(paymentMenu);

        Kickstarter kickstarter = new Kickstarter(categoriesMenu, textView, new QuoteGenerator(new Random()));
        kickstarter.run();
    }

    public static void initializeDB() {
        try (Connection connection = new DBConnector("conf/h2db.properties").getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Categories (" +
                    " id INT PRIMARY KEY AUTO_INCREMENT," +
                    " name VARCHAR(255) )");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
