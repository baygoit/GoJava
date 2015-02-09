package com.gojava.quote;

import com.gojava.inputOutput.IO;

public class Quote {
    public IO consoleIO;
    
    public Quote(IO consoleIO) {
        this.consoleIO = consoleIO;
    }

    private String quote = "This is motivating creativity quote!!";

    public String getQuote() {
        return quote;
    }

}
