package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;

public class Launcher {
    public static void main(String[] args) {
        QuoteStorage quoteStorage = new QuoteStorage();
        CategoryStorage categoryStorage = new CategoryStorage();
        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        Controller controller = new Controller(kickstarter);
        ConsoleView view = new ConsoleView(controller);
        view.run();
    }
}
