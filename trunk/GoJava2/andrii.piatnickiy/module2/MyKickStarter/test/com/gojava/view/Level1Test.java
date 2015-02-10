package com.gojava.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.projects.CategoryStorage;

public class Level1Test {
    CategoryStorage categoryStorage = new CategoryStorage();
    
    @Test
    public void shouldGetCategoryToString_WhenDisplayMySelf(){
        categoryStorage.add("name1", 1);
        Level1 level1 = new Level1(categoryStorage);
        String actual = level1.displayMySelf(0);
        assertEquals("1) name1\n", actual);
    }
}
