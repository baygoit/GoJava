package com.gojava.launch;

import com.gojava.inputOutput.Out;
import com.gojava.inputOutput.Scan;
import com.gojava.quote.Quote;
import com.gojava.view.Menu;

public class Launch {

    public static void main(String[] args) {
        Out out = new Out();
        Scan scan = new Scan();
        Quote quote = new Quote();
        out.print(quote.getQuote());

        Menu menu = new Menu();
        while (true) {
            menu.nextLevel(scan.inputInt());
        }
    }
}
