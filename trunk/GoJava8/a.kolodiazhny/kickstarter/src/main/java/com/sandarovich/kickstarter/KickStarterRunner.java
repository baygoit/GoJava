package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;

/**
 * Kick starter starting tool
 */

public class KickStarterRunner {

    public static final String DAO_MODE = "mode";

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        DaoMode daoMode = DaoMode.fromName(System.getProperty(DAO_MODE));
        new KickStarter(io, daoMode).run();
    }
}
