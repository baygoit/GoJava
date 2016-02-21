package com.sandarovich.module1.numbersdivider;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for NumbersDivider.
 */

public class NumbersDividerTest {
    private NumbersDivider numbersDivider;
    private IO io;

    @Before
    public void initialize() {
        io = new ConsoleIO();
        numbersDivider = new NumbersDivider(io);

    }

    @Ignore
    @Test(expected = NumberFormatException.class)
    public void testNotIntNumbersInInput() throws Exception {
        io.parse("@");
    }

    @Ignore
    @Test(expected = NumberFormatException.class)
    public void testNullInInput() throws Exception {
        io.parse(null);
    }

    @Ignore
    @Test(expected = NumberFormatException.class)
    public void testNegativeNumberInInput() throws Exception {
        io.parse("-3");
    }

    @Test
    public void testDividenAlgorithmDividenGreatThenDivider() {
        //given
        numbersDivider.setDividen(512);
        numbersDivider.setDivider(8);
        //then
        assertEquals("1", numbersDivider.calculate());

    }


}
