package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Kickstarter;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

import java.util.List;
import java.util.Random;

public class MainController {
    private static final Random RANDOM = new Random();

    private Kickstarter kickstarter;

    public MainController(Kickstarter kickstarter) {
        this.kickstarter = kickstarter;
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = kickstarter.getQuotes();
        int numberOfQuotes = quotes.size();
        int randomNumber = RANDOM.nextInt(numberOfQuotes);
        return quotes.get(randomNumber);
    }

    public Category getCategory(int number) {
        List<Category> categories = kickstarter.getCategories();
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

    public void askQuestion(Project project, String question) {
        kickstarter.addQuestion(project, question);
    }

    public void donate(Project project, int sum) {
        kickstarter.addDonation(project, sum);
    }

    public List<Category> getCategories() {
        return kickstarter.getCategories();
    }
}
