/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;

/**
 *
 * @author Salivon Ivan
 */
public class ManagerFileDataTest {
    
    public ManagerFileDataTest() {
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
     * Test of getRandomQuote method, of class ManagerFileData.
     */
    @Test
    public void testGetRandomQuote() {
        System.out.println("getRandomQuote");
        ManagerFileData instance = new ManagerFileData();
        String expResult = "";
        String result = instance.getRandomQuote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCategories method, of class ManagerFileData.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");
        ManagerFileData instance = new ManagerFileData();
        List<Category> expResult = null;
        List<Category> result = instance.getAllCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class ManagerFileData.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        int idCategory = 0;
        ManagerFileData instance = new ManagerFileData();
        Category expResult = null;
        Category result = instance.getCategory(idCategory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectsOfCategory method, of class ManagerFileData.
     */
    @Test
    public void testGetProjectsOfCategory() {
        System.out.println("getProjectsOfCategory");
        int idCategory = 0;
        ManagerFileData instance = new ManagerFileData();
        List<Project> expResult = null;
        List<Project> result = instance.getProjectsOfCategory(idCategory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class ManagerFileData.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        int idProject = 0;
        ManagerFileData instance = new ManagerFileData();
        Project expResult = null;
        Project result = instance.getProject(idProject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFaq method, of class ManagerFileData.
     */
    @Test
    public void testSaveFaq() {
        System.out.println("saveFaq");
        Faq faq = null;
        ManagerFileData instance = new ManagerFileData();
        instance.saveFaq(faq);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaq method, of class ManagerFileData.
     */
    @Test
    public void testGetFaq() {
        System.out.println("getFaq");
        int idProject = 0;
        ManagerFileData instance = new ManagerFileData();
        String expResult = "";
        String result = instance.getFaq(idProject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePayment method, of class ManagerFileData.
     */
    @Test
    public void testSavePayment() {
        System.out.println("savePayment");
        Payment payment = null;
        ManagerFileData instance = new ManagerFileData();
        instance.savePayment(payment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class ManagerFileData.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        int idProject = 0;
        ManagerFileData instance = new ManagerFileData();
        int expResult = 0;
        int result = instance.getTotal(idProject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
