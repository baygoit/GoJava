package com.sandarovich.module1.columndivision;

/**
 * @author Olexander Kolodiahzny 2016 Module #1. Task #4 Column Divide algorithm
 *         with text output
 *
 */

public class App {
    
    private App () {
        
    }
    
    public static void main(String[] args) {
        
        Reader reader = new Reader();
        Parser parser = new Parser ();
        Output output = new ConsoleOutput();
        
        output.askUserForInput();
        String userInput = reader.readFromKeyboard();
        
        if (parser.isParsed(userInput)) {
            output.parseSuccessfully();
            ColumnDivision columnDivision = new ColumnDivision(parser.getDividen(), parser.getDivider());
            output.showResult(columnDivision.getResults());
        } else {
            output.parseUnSuccessfully();
        }
        
    }
}
