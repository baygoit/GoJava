package com.gojava.launch;

import org.junit.Test;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.inputOutput.FakeIO;
import com.gojava.inputOutput.IO;
import com.gojava.quote.Quote;

public class TestLaunch {
    
    //TODO переделать под Fake
    @Test
    public void aaa(){
        Quote quote = new Quote(new ConsoleIO());
        quote.consoleIO.print(quote.getQuote());
    }
}
