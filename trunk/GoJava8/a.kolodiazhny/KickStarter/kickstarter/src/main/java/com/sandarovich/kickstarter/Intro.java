package com.sandarovich.kickstarter;

/**
 * @author Olexander Kolodiazhny 2016
 *
 *         Show Application name, author and quote.
 */
public class Intro  {
    private Output output;
    private String appVersion;

    public Intro(Output output, String appVersion) {
        this.output = output;
        this.appVersion = appVersion;
    }

    public void show() {
        showAuthor();
        showQuote();
    }

    private void showAuthor() {
        output.print("=======================================");
        output.print("     Kickstarter emulator v." + appVersion);
        output.print("     by O.Kolodiazhny 2016      ");
        output.print("=======================================");
    }

    private void showQuote() {
        output.print("\"Every big journey begins with a small step\"\n");
    }

}
