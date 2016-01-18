package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.QuoteStorage;

import java.io.IOException;

public class Kickstarter  {
    private CategoryStorage categoryStorage;

    private QuoteStorage quoteStorage;

    public Kickstarter(CategoryStorage categoryStorage, QuoteStorage quoteStorage) {
        this.categoryStorage = categoryStorage;
        this.quoteStorage = quoteStorage;
    }

    public CategoryStorage getCategoryStorage() {
        return categoryStorage;
    }

    public QuoteStorage getQuoteStorage() {
        return quoteStorage;
    }

    public void addDonation(Project project, int money) throws IOException {
        project.addMoneyDonated(money);
    }

    public void addQuestion(Project project, String question) throws IOException {
        project.addQuestion(question);
    }


}
