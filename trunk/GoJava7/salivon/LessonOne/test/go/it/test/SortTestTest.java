/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.it.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salivon.i
 */
public class SortTestTest {
    
    public SortTestTest() {
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
     * Test of setUp method, of class SortTest.
     */
    @Test
    public void testSetUp() throws Exception {
        System.out.println("setUp");
        SortTest.setUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testNullList method, of class SortTest.
     */
    @Test
    public void testTestNullList() {
        System.out.println("testNullList");
        SortTest instance = new SortTest();
        instance.testNullList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testEmptyList method, of class SortTest.
     */
    @Test
    public void testTestEmptyList() {
        System.out.println("testEmptyList");
        SortTest instance = new SortTest();
        instance.testEmptyList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testSimpleList method, of class SortTest.
     */
    @Test
    public void testTestSimpleList() {
        System.out.println("testSimpleList");
        SortTest instance = new SortTest();
        instance.testSimpleList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
