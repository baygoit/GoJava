package com.azuiev;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit register.html for simple App.
 */
public class AirBnBTest
    extends TestCase
{
    /**
     * Create the register.html case
     *
     * @param testName name of the register.html case
     */
    public AirBnBTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AirBnBTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
