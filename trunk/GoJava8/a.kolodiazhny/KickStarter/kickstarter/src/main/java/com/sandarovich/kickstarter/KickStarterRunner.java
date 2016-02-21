package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;

/**
 * @author Olexander Kolodiazhny 2016
 */

public class KickStarterRunner {

    private KickStarterRunner() {

    }

    public static void main(String[] args) {
        IO console = new ConsoleIO();
        new KickStarter(console).start();
    }
}
