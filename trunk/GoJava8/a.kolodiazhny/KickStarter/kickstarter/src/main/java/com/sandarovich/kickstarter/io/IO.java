package com.sandarovich.kickstarter.io;

/**
 * @author Olexander Kolodiazhny 2016 
 * Describe common text output
 */

public interface IO {
    void write(String message);
    String read();

    void writeTable(Tableable object);
}
