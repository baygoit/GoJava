package com.sandarovich.kickstarter.category;

/**
 * Tests for Category Source
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CategorySourceTest {

    @Test
    public void testGetAllCategories() {
        CategorySource cs = new CategorySource();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertThat("Get all Categories", cs.getAllCategories(),
                is("1 -> IT\n2 -> Tourism\n"));
    }


    @Test
    public void testGetCategoryByIdNotFoundValue() {
        CategorySource cs = new CategorySource();
        cs.init();
        assertNull(cs.getCategoryById(-1));
    }

    @Test
    public void testGetCategoryByIdValueExist() {
        CategorySource cs = new CategorySource();
        Category category = new Category(777, "IT");
        cs.add(category);
        cs.add(new Category(2, "Garden"));
        assertEquals(category, cs.getCategoryById(777));

    }

    @Test
    public void testIsValidCategoryValid() {
        CategorySource cs = new CategorySource();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(true, cs.isValidCategory("1"));
    }

    @Test
    public void testIsValidCategoryLetters() {
        CategorySource cs = new CategorySource();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(false, cs.isValidCategory("ZZZZ"));
    }

    @Test
    public void testIsValidCategoryNotValid() {
        CategorySource cs = new CategorySource();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(false, cs.isValidCategory("9"));
    }

    @Test
    public void testSize() {
        CategorySource cs = new CategorySource();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(2, cs.size());
    }


}

