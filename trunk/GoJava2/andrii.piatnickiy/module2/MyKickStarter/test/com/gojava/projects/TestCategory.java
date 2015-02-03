package com.gojava.projects;
import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.projects.Category;

public class TestCategory {

    @Test
    public void testGetCategoryName() {
        Category  category = new Category("name", 1);
        String actual = category.getName();
        assertTrue(actual == "name");
    }
    @Test
    public void testGetCategoryId() {
        Category  category = new Category("name", 1);
        int actual = category.getCategoryId();
        assertTrue(actual == 1);
    }
    @Test
    public void testToString() {
        Category  category = new Category("name", 1);
        String actual = category.toString();
        assertTrue(actual.equals("1) name"));
    }
}

    
