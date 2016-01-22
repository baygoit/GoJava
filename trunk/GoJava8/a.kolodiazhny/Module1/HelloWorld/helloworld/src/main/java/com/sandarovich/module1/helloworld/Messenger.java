package com.sandarovich.module1.helloworld;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 *
 */

public class Messenger {

    private OutputFormatter outputFormatter;

    public OutputFormatter getOutputFormatter() {
        return outputFormatter;
    }


    public void setOutputFormatter(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }     
        
    public void showMessage(String message) {
        this.outputFormatter.processMessage(message);
    }
  
}
