package com.gojava.launch;

import com.gojava.input.Scan;
import com.gojava.quote.Quote;
import com.gojava.view.Menu;

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
