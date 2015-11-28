package ua.com.goit.gojava7.salivon.beans;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CategoryTest {

    Category instance;

    @Before
    public void setUp() {
        instance = new Category("Art", 5);
    }

    @Test
    public void testGetId() {
        int expResult = 5;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetId() {
        int id = 0;
        instance.setId(id);
        assertEquals(0, instance.getId());
    }

    @Test
    public void testGetName() {
        String expResult = "Art";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetName() {
        String name = "Games";
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

}
