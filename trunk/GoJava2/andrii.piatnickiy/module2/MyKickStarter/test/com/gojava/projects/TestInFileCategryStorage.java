package com.gojava.projects;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInFileCategryStorage extends TestCategoryStorage{
    ArrayList<Category> resultList;
    InFileCategoryStorage categoryStorage = new InFileCategoryStorage("categoriesTest.txt");
    
    @Before
    public void setListCategories(){
        resultList = categoryStorage.getCategoriesFromFileToList();
    }
    @Override
    CategoryStorage getCategoryStorage() {
        return categoryStorage;
    }
    
    @After
    public void cleanUp(){
        categoryStorage.file.delete();
    }
    
    @Test
    public void shouldGetCategoriesFromFileToList_WhenReadFileGategories(){
        
        String actual = "";
        for(Category category : resultList){
            actual += category.toString() + "\n";
        }
        assertEquals("1) name1\n2) name2\n3) name3\n4) name4\n", actual);
    }
}
