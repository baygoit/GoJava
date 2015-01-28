package org.kudryavtsev.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
