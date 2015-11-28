/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.it.salivon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Оля
 */
public class ReverseStringTest {
    
    public ReverseStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ReverseString.
     */
//    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ReverseString.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseWords method, of class ReverseString.
     */
    @Test
    public void testReverseWords() {
        System.out.println("reverseWords");
        String phrase = " 21 ";
        ReverseString instance = new ReverseString();
        String expResult = " 12 ";
        String result = instance.reverseWords(phrase);
        assertEquals(expResult, result);
        
        
    }
    
}
