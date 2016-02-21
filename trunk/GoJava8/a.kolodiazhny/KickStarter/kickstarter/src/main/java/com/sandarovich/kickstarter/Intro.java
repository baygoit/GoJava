package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.IO;

/**
 * @author Olexander Kolodiazhny 2016
 *
 *         Show Application name, author and quote.
 */
public class Intro  {
    private final IO console;

    public Intro(IO output) {
        this.console = output;
    }

    public void show() {
        showAuthor();
        showQuote();
    }

    private void showAuthor() {
        console.write("=======================================");
        console.write("     Kickstarter emulator v." + KickStarter.APPLICATION_VERSION);
        console.write("     by O.Kolodiazhny 2016      ");
        console.write("=======================================");
    }

    private void showQuote() {
        console.write("\"Every big journey begins with a small step\"\n");
    }

}
