package com.sandarovich.module1.columndivision;

/**
 * @author Olexande rKolodiazhny 2016
 * 
 * Parse text to dividen and divider
 *
 */

public class Parser {
    
    private int dividen;
    private int divider;
    
    public int getDividen() {
        return dividen;
    }
    
    public int getDivider() {
        return divider;
    }
    
    public boolean isParsed(String userInput) {
        
        if (userInput == null || userInput.equals("-1")) {
            return false;
        } else {
            String[] numbers = userInput.split(Strings.DIVIDER.toString());

            try {
                dividen = Integer.parseInt(numbers[0]);
                divider = Integer.parseInt(numbers[1]);
            } catch (Exception e) {
                return false;
            }
            
            return true;
        }
    }

}
