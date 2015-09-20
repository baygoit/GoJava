package com.gojava.projects;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gojava.projects.CategoryStorage;

public abstract class TestCategoryStorage {
    CategoryStorage categoryStorage;

    @Before
    public void setup() {
        categoryStorage = getCategoryStorage();
        ArrayList<Category> list = categoryStorage.getList();
        categoryStorage.add("name1", 1);
        categoryStorage.add("name2", 2);
        categoryStorage.add("name3", 3);
        categoryStorage.add("name4", 4);
    }

    abstract CategoryStorage getCategoryStorage();

    @Test
    public void shouldCategoriestList_WhenAddCategoriesList() {
        Category category = categoryStorage.getCategory(0);
        assertEquals("1) name1", category.toString());
    }

    @Test
    public void shouldDisplayAllCatgories_WhendCallgetCategoriesToString() {
        String actual = categoryStorage.getCategoryToString();
        assertEquals("1) name1" + "\n" + "2) name2" + "\n" + "3) name3" + "\n"
                + "4) name4" + "\n", categoryStorage.getCategoryToString());
    }
}
