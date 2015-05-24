package ua.com.goit.gojava.kickstarter.model;

import org.junit.Test;

public class CategoryTest {
    
    Category category = new Category("TEST_CATEGORY", 666);
    
    @Test
    public void getIdTest() {
   	category.getId();
       }
}
