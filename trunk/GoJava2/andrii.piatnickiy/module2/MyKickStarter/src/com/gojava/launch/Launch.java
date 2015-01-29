package com.gojava.launch;

import Quote.Quote;
import View.Menu;

import com.gojava.input.Scan;

public class Launch {

    public static void main(String[] args) {
        Scan scan = new Scan();
        Quote quote = new Quote();
        quote.displayQuote();

        Menu menu = new Menu();
        while (true) {
            menu.nextLevel(scan.inputInt());
        }
    }
}
