package com.sandarovich.kickstarter;

/**
 * @author Olexander Kolodiazhny
 * 
 *         Output text to user console
 *
 */

public class ConsoleOutput implements Output {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

}
