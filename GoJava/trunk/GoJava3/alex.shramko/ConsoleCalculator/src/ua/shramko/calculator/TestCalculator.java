package ua.shramko.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculator {

    @Test
    public void test() {
        assertEquals("4", new Calculator("2+2").toString());
        assertEquals("4", new Calculator("2 + 2").toString());
        assertEquals("11(2)", new Calculator("1(2) + 2").toString());
        assertEquals("1111(2)", new Calculator("1010(2)+101(2)").toString());
        assertEquals("B006(16)", new Calculator("AB34(16)+1234").toString());
        assertEquals("XVI(r)", new Calculator("IV(r)+12").toString());
        assertEquals("X(r)", new Calculator("IV(r)+VI(r)").toString());
    }

}
