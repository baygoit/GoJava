package com.airbnb.system;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by root on 27.09.15.
 */
public class Log {

    public static Logger logger = Logger.getLogger("com.airbnb.system");
    private static FileHandler fileHandler;

    public static FileHandler getFileHandler() {
        return fileHandler;
    }

    public static void setFileHandler() {
        try {
            Log.fileHandler = new FileHandler("Logger.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        }
        catch (Exception ex) {
            System.out.println("Some problem with Logger");
        }
    }
}
