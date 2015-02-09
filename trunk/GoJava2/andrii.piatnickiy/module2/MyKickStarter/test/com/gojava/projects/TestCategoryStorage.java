package com.gojava.projects;
import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.projects.CategoryStorage;

public class TestCategoryStorage {
    CategoryStorage categoryStorage = new CategoryStorage();
    
    @Test
    public void shouldCategoriestList_WhenAddCategoriesList(){
        categoryStorage.add("name1", 1);
        Category category = categoryStorage.getCategory(0);
        assertEquals("1) name1", category.toString());
    }
    
  @Test
  public void shouldDisplayAllCatgories_WhendCallgetCategoriesToString(){
      StringBuffer sb = new StringBuffer();
      categoryStorage.add("name1", 1);
      categoryStorage.add("name2", 2);
      categoryStorage.add("name3", 3);
      assertEquals("1) name1", categoryStorage.getCategoryToString(categoryStorage.getCategory(0)));
  }
}
