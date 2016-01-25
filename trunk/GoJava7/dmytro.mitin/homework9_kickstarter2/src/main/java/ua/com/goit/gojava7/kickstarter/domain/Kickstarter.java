package ua.com.goit.gojava7.kickstarter.domain;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

import java.util.List;

public class Kickstarter  {
    private CategoryDao categoryDao;

    private QuoteDao quoteDao;

    public Kickstarter(CategoryDao categoryDao, QuoteDao quoteDao) {
        this.categoryDao = categoryDao;
        this.quoteDao = quoteDao;
    }

    public void addDonation(Project project, int money) {
        project.addMoneyDonated(money);
    }

    public void addQuestion(Project project, String question) {
        project.addQuestion(question);
    }


    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    public List<Quote> getQuotes() {
        return quoteDao.getQuotes();
    }
}
