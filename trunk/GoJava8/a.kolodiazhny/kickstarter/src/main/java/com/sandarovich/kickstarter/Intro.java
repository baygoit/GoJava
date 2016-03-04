package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.IO;

/**
 * Show Application name, author and quote.
 */

public class Intro {
    private final IO console;

    public Intro(IO output) {
        this.console = output;
    }


    public void showApplicationAuthor() {
        console.write("=======================================");
        console.write("     Kickstarter emulator v." + KickStarter.APPLICATION_VERSION);
        console.write("     by O.Kolodiazhny 2016      ");
        console.write("=======================================");
    }

    public void showQuote() {
        console.write(new QuotaGenerator().getQuota());
    }

}
