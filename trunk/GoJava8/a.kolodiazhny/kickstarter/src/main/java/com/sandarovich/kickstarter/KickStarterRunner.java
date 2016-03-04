package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;

/**
 *  Kick starter starting tool
 */

public class KickStarterRunner {
    public static void main(String[] args) {
        IO console = new ConsoleIO();
        new KickStarter(console).start();
    }
}
