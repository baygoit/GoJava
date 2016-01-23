package com.sandarovich.module1.helloworld;


/**
 * @author Olexander Kolodiazhny 2016
 * 
 * Output to console
 *
 */
public class SimpleConsoleOutput implements OutputFormatter {

    public void processMessage(String message) {
	System.out.print(message);	
    }

}
