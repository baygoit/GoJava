package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.view.TextView;

public class Kickstarter {

    private TextView textView;
    private Menu mainMenu;
    private QuoteGenerator quoteGenerator;

    public Kickstarter(Menu mainMenu, TextView textView, QuoteGenerator quoteGenerator) {
        this.mainMenu = mainMenu;
        this.textView = textView;
        this.quoteGenerator = quoteGenerator;
    }

    public void run() {
        String quote = quoteGenerator.getQuote();
        textView.printMessage(quote);
        mainMenu.run();
    }

}
