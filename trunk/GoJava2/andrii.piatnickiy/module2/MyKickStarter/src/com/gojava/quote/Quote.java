package com.gojava.quote;

import com.gojava.inputOutput.IO;

public class Quote {
    public IO iO;
    
    public Quote(IO iO) {
        this.iO = iO;
    }

    private String quote = "This is motivating creativity quote!!";

    public String getQuote() {
        return quote;
    }

}
