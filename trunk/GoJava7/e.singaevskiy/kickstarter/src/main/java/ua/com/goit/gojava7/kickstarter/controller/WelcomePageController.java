package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Quote;

@SuppressWarnings("rawtypes")
public class WelcomePageController extends PageController {

    private List<Category> categories;

    @Override
    protected void handle() {
        
        Random rnd = new Random();
        
        List<Quote> quotes = storageFactory.getQuoteDAO().getAll();

        if (!quotes.isEmpty()) {
            page.showQuote(quotes.get(rnd.nextInt(quotes.size())));
        }
        
        categories = storageFactory.getCategoryDAO().getAll();
        page.showCategories(categories);       
        
    }

    @SuppressWarnings("unchecked")
    @Override
    protected boolean isDone() {
        int option = getMenuOptionFromUser(categories.size());

        if (option == OPTION_EXIT) {
            return true;
        } else { 
            
            dispatchNext(categories.get(option-1), new ProjectListPageController());
            
            return false;
        }
    }

}
