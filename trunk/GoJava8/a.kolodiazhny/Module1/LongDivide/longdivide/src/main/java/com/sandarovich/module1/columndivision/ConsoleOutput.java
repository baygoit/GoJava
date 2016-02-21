package com.sandarovich.module1.columndivision;

import java.util.List;

/**
 * @author Olexande Kolodiazhny 2016
 * 
 *         Output messages to user console
 *
 */
public class ConsoleOutput implements Output {

    public void parseSuccessfully() {
        
        System.out.println(">> Input parsed Successfully<<");
    }

    public void parseUnSuccessfully() {
        
        System.out.println("\nWARNING!. Input is incorrect. Bye \n");
    }
    
    public void askUserForInput() {
        
        System.out.println("Please enter input. Example \"12/42\"");
    }

   
    public void showResult(List<String> results) {
        
        System.out.println("Results: ");
        for (String line : results) {
            System.out.println(line);
        }
        
    }
}
