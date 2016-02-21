package com.sandarovich.module1.numbersdivider;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testNegativeNumbersInInput() {
        //given

        //when

        //then
    }



}
