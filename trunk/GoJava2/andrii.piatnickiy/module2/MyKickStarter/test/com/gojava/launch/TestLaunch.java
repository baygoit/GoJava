package com.gojava.launch;

import org.junit.Test;

import com.gojava.inputOutput.FakeIO;
import com.gojava.inputOutput.IO;
import com.gojava.quote.Quote;

public class TestLaunch {
    @Test
    public void aaa(){
        Quote quote = new Quote(new FakeIO());
        quote.iO.print(quote.getQuote());
    }
}
