package org.kudryavtsev.kickstarter.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kudryavtsev.kickstarter.Category;

public class CategoryTest {

    @Test
    public void shouldBeCertainString_whenNewCertainCategory() {
        String expected = "Movies - Movies category";
        String actual = "";
        Category category = new Category("Movies", "Movies category");
        actual = category.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldBeDefault_whenNewDefaultnCategory() {
        String expected = "Other - For other projects";
        String actual = "";
        Category category = new Category();
        actual = category.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCategory() {
        fail("Not yet implemented");
    }

    @Test
    public void testCategoryStringString() {
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetProjectsList() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetProjectsList() {
        fail("Not yet implemented");
    }

}
