package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.QuoteStorage;

/**
 * Created by Dmytro on 06.11.2015.
 */
public class Kickstarter {
    public static void main(String[] args) {
        QuoteStorage quoteStorage = new QuoteStorage();
        CategoryStorage categoryStorage = new CategoryStorage();
        Controller controller = new Controller(quoteStorage, categoryStorage, null);
        controller.run();
    }
}
