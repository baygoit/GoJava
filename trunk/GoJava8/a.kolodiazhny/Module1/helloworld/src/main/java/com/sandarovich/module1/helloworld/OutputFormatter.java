package com.sandarovich.module1.helloworld;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 * Interface for getting message and appropriate output according
 * to chosen outputFormat (console, log, e.t.c)
 *
 */
public interface OutputFormatter {
    public void processMessage(String message);
}
