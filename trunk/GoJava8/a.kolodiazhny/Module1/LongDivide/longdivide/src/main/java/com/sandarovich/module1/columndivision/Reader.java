package com.sandarovich.module1.columndivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 *         Read String from user console and parse into dividen, divider
 *
 */

public class Reader {
    
    public String readFromKeyboard() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            inputString = "-1";
        }
        return inputString;
    }

    

}
