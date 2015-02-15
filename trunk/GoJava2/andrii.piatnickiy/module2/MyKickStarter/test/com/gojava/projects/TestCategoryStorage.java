package com.gojava.projects;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gojava.projects.CategoryStorage;

public abstract class TestCategoryStorage {
    CategoryStorage categoryStorage;
    @Before
    public void setup(){
        categoryStorage = getCategoryStorage();    
    }


    abstract CategoryStorage getCategoryStorage();
    
    
    @Test
    public void shouldCategoriestList_WhenAddCategoriesList(){
        categoryStorage.add("name1", 1);
        Category category = categoryStorage.getCategory(0);
        assertEquals("1) name1", category.toString());
    }
    
    @Test
    public void shouldDisplayAllCatgories_WhendCallgetCategoriesToString(){
      categoryStorage.add("name1", 1);
      categoryStorage.add("name2", 2);
      categoryStorage.add("name3", 3);
      assertEquals("1) name1" + "\n" + "2) name2" + "\n" + "3) name3" + "\n", categoryStorage.getCategoryToString());
    }
}
