package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.storage.*;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.View;

public class Launcher {
    public static void main(String[] args) {
        QuoteStorage quoteStorage;
        CategoryStorage categoryStorage;
        if (args != null && args.length > 0 && args[0] == "f") {
            quoteStorage = new FileQuoteStorage();
            categoryStorage = new FileCategoryStorage();
        } else if (args != null && args.length > 0 && args[0] == "d") {
            quoteStorage = new DatabaseQuoteStorage();
            categoryStorage = new DatabaseCategoryStorage();
        } else {
            quoteStorage = new InMemoryQuoteStorage();
            categoryStorage = new InMemoryCategoryStorage();
        }
        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        Controller controller = new Controller(kickstarter);
        View view = new ConsoleView(controller);
        view.run();
    }
}
