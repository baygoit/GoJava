package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;
import ua.com.goit.gojava7.kickstarter.model.storage.*;
import ua.com.goit.gojava7.kickstarter.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro on 07.11.2015.
 */
public class Kickstarter implements KickstarterObservable {
    CategoryStorage categoryStorage;

    QuoteStorage quoteStorage;

    // implementing Observer pattern
    List<View> views;

    public Kickstarter(CategoryStorage categoryStorage, QuoteStorage quoteStorage) {
        this.categoryStorage = categoryStorage;
        this.quoteStorage = quoteStorage;
        this.views = new ArrayList<>();
    }

    public CategoryStorage getCategoryStorage() {
        return categoryStorage;
    }

    public QuoteStorage getQuoteStorage() {
        return quoteStorage;
    }

    public void addDonation(Project project, int money) throws ExitException {
        project.addMoneyDonated(money);
        notifyView();
    }

    // implementing Observer pattern
    @Override
    public void notifyView() throws ExitException {
        for (View view : views) {
            view.reloadPage();
        }
    }

    @Override
    public void addObserver(View view) {
        views.add(view);
    }

    @Override
    public void removeObserver(View view) {
        views.remove(view);
    }
}
