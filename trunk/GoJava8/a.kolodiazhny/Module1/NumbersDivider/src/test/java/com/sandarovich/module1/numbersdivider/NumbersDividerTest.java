package com.sandarovich.module1.numbersdivider;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for NumbersDivider.
 */

public class NumbersDividerTest {
    private NumbersDivider numbersDivider;
    private IO io;

    @Before
    public void initialize() throws IOException {
        io = new ConsoleIO();
        numbersDivider = new NumbersDivider(io);

    }

    @Test(expected = NumberFormatException.class)
    public void testNotIntNumbersInInput() throws Exception {
        io.parse("@");
    }

    @Test(expected = NumberFormatException.class)
    public void testNullInInput() throws Exception {
        io.parse(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testNegativeNumberInInput() throws Exception {
        io.parse("-3");
    }


}
