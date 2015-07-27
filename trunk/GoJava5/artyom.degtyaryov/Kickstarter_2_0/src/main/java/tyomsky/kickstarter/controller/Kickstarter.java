package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.dao.ProjectsDAO;
import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.ui.IO;

public class Kickstarter {

    private IO io;
    private Menu mainMenu;
    private QuoteGenerator quoteGenerator;

    public Kickstarter(Menu mainMenu, IO io, QuoteGenerator quoteGenerator) {
        this.mainMenu = mainMenu;
        this.io = io;
        this.quoteGenerator = quoteGenerator;
    }

    public void run() {
        String quote = quoteGenerator.getQuote();
        io.println(quote);
        mainMenu.run();
    }

}
