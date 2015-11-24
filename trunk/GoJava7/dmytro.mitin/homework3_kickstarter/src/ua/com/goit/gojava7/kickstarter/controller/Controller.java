package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

import java.util.List;
import java.util.Random;

public class Controller {
    private static final Random RANDOM = new Random();

    private Kickstarter kickstarter;

    public Controller(Kickstarter kickstarter) {
        this.kickstarter = kickstarter;
    }

    public Kickstarter getKickstarter() {
        return kickstarter;
    }

    public void donate(Project project, int sum) throws ExitException {
        kickstarter.addDonation(project, sum);
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = kickstarter.getQuoteStorage().getQuotes();
        int numberOfQuotes = quotes.size();
        int randomNumber = RANDOM.nextInt(numberOfQuotes);
        return quotes.get(randomNumber);
    }

    public Category getCategory(int number) {
        List<Category> categories = kickstarter.getCategoryStorage().getCategories();
        if (number < 0 || number >= categories.size()) {
            return null;
        }
        return categories.get(number);
    }

    public Project getProject(int number, Category category) {
        List<Project> projects = category.getProjects();
        if (number < 0 || number >= projects.size()) {
            return null;
        }
        return projects.get(number);
    }
}
