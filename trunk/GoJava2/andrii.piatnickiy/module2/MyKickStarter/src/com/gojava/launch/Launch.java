package com.gojava.launch;

import Quote.Quote;
import View.Menu;

import com.gojava.input.Scan;

public class Launch {

    public static void main(String[] args) {
        int nubberForNextLevel;
        Scan scan = new Scan();
        Quote quote = new Quote();
        Menu menu = new Menu();

        quote.displayQuote();

        menu.initMenu();
        while (true) {
            nubberForNextLevel = scan.inputInt();
            menu.nextLevel(nubberForNextLevel);
        }
    }
}
