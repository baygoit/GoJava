package com.azuiev;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit register.jsp for simple App.
 */
public class AirBnBTest
    extends TestCase
{
    /**
     * Create the register.jsp case
     *
     * @param testName name of the register.jsp case
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
