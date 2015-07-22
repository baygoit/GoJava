package tyomsky.kickstarter;

import tyomsky.kickstarter.controller.Kickstarter;
import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.dao.CategoriesDAOFile;
import tyomsky.kickstarter.dao.Projects;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.ui.ConsoleIO;

import java.util.Random;

public class BootStrap {

    public static void main(String[] args) {
        CategoriesDAO categories = new CategoriesDAOFile("categories.txt");

        Projects projects = new Projects();
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

        Kickstarter kickstarter = new Kickstarter(categories, projects, new ConsoleIO(), new QuoteGenerator(new Random()));
        kickstarter.run();
    }
}
