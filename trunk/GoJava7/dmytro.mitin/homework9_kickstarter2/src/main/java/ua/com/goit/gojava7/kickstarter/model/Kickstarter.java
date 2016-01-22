package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.QuoteStorage;

import java.util.List;

public class Kickstarter  {
    private CategoryStorage categoryStorage;

    private QuoteStorage quoteStorage;

    public Kickstarter(CategoryStorage categoryStorage, QuoteStorage quoteStorage) {
        this.categoryStorage = categoryStorage;
        this.quoteStorage = quoteStorage;
    }

    public void addDonation(Project project, int money) {
        project.addMoneyDonated(money);
    }

    public void addQuestion(Project project, String question) {
        project.addQuestion(question);
    }


    public List<Category> getCategories() {
        return categoryStorage.getCategories();
    }

    public List<Quote> getQuotes() {
        return quoteStorage.getQuotes();
    }
}
