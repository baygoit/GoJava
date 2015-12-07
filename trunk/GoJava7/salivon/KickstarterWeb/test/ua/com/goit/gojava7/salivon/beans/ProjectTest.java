package ua.com.goit.gojava7.salivon.beans;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ProjectTest {

    Project instance;

    @Before
    public void setUp() {
        instance = new Project("Art", 100, 1, 1);
    }

    @Test
    public void testGetDateStart() {
        assertNotNull(instance.getDateStart());

    }

    @Test
    public void testGetIdCategory() {
        int expResult = 1;
        int result = instance.getIdCategory();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetIdCategory() {
        int idCategory = 2;
        instance.setIdCategory(idCategory);
        assertEquals(2, instance.getIdCategory());
    }

    @Test
    public void testGetTitle() {
        String expResult = "Art";
        String result = instance.getTitle();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetTitle() {
        String title = "Games";
        instance.setTitle(title);
        assertEquals(title, instance.getTitle());
    }

    @Test
    public void testGetDescription() {
        String expResult = "...description...";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetDescription() {
        String description = "";
        instance.setDescription(description);
        assertEquals("", instance.getDescription());
    }

    @Test
    public void testGetTotal() {
        int expResult = 100;
        int result = instance.getTotal();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetTotal() {
        int total = 10;
        instance.setTotal(total);
        assertEquals(10, instance.getTotal());

    }

    @Test
    public void testGetNumberOfDaysToImplement() {
        int expResult = 0;
        int result = instance.getNumberOfDaysToImplement();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetNumberOfDaysToImplement() {
        int numberOfDaysToImplement = 10;
        instance.setNumberOfDaysToImplement(numberOfDaysToImplement);
        assertEquals(10, instance.getNumberOfDaysToImplement());
    }

    @Test
    public void testGetHistoryProject() {
        String expResult = "...history...";
        String result = instance.getHistoryProject();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetHistoryProject() {
        String historyProject = "";
        instance.setHistoryProject("");
        assertEquals("", instance.getHistoryProject());
    }

    @Test
    public void testGetLink() {
        String expResult = "...link...";
        String result = instance.getLink();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetLink() {
        String link = "";
        instance.setLink(link);
        assertEquals("", instance.getLink());
    }

    @Test
    public void testGetCollectedAmount() {
        int expResult = 0;
        int result = instance.getCollectedAmount();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetCollectedAmount() {
        instance.setCollectedAmount(20);
        int result1 = instance.getCollectedAmount();
        instance.setCollectedAmount(5);
        int result2 = instance.getCollectedAmount();
        assertEquals(20, result1);
        assertEquals(25, result2);
    }

    @Test
    public void testGetFaq() {
        String expResult = "...FAQ...";
        String result = instance.getFaq();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetFaq() {
        instance.setFaq("");
        String result1 = instance.getFaq();

        instance.setFaq("Hello");
        String result2 = instance.getFaq();
        assertEquals("...FAQ...\n", result1);
        assertEquals("...FAQ...\nHello\n", result2);
    }

    @Test
    public void testGetId() {
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        instance.setId(2);
        assertEquals(2, instance.getId());

    }

    @Test
    public void testGetNumberOfDaysToEnd() {
        System.out.println("getNumberOfDaysToEnd");
        int expResult = 0;
        int result = instance.getNumberOfDaysToEnd();
        assertEquals(expResult, result);

    }

}
