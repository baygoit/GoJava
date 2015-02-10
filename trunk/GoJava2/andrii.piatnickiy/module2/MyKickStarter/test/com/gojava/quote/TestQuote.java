package com.gojava.quote;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.quote.Quote;

public class TestQuote {
    Quote quote = new Quote(null);
    @Test
    public void shoultReturnString_WhenInputString(){
        String actual = quote.getQuote();
        assertTrue(actual.equals("This is motivating creativity quote!!"));
    }
}
