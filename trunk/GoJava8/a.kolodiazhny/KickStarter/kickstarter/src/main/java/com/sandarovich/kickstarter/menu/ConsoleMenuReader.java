package com.sandarovich.kickstarter.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sandarovich.kickstarter.ConsoleOutput;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class ConsoleMenuReader implements MenuReader {

    @Override
    public int read() {
        String resultStr = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            resultStr = reader.readLine();
        }
        catch (IOException e) {
            new ConsoleOutput().print(">> Exception.Unable to read input");
        }
        
        return parse(resultStr);
    }

   private int parse(String inputStr) {
       int result = -1;
       try {
           result = Integer.parseInt(inputStr);
       } catch(Exception e) {
           new ConsoleOutput().print(">> Only numbers is allowed");
       }
       
       return result;     
   }
    
  
}
