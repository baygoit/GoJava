package com.azuiev;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit RegistrationForm.html for simple App.
 */
public class AirBnBTest
    extends TestCase
{
    /**
     * Create the RegistrationForm.html case
     *
     * @param testName name of the RegistrationForm.html case
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
