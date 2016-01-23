package com.sandarovich.module1.helloworld;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 * Console based utility. 
 * Outputs static message "Hello World!" to user console. 
 *
 */

public class App {
    public static void main(String[] args) {
	
	String message = "Hello World!"; 
	
	Messenger messenger = new Messenger();
	messenger.setOutputFormatter(new SimpleConsoleOutput());
	messenger.showMessage(message);
    }
}
