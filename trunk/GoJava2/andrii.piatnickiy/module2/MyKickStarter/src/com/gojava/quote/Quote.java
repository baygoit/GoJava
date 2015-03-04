package com.gojava.quote;

import com.gojava.inputOutput.ConsoleIO;

public class Quote {
    //TODO переделать ConsoleIO
    public ConsoleIO consoleIO;
    
    public Quote(ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
    }

    private String quote = "This is motivating creativity quote!!";

    public String getQuote() {
        return quote;
    }

}
