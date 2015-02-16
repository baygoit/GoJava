package com.gojava.projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;

public class TestInFileCategryStorage extends TestCategoryStorage{

    
    @Override
    CategoryStorage getCategoryStorage() {
        return new FileCategoryStorage("categoriesTest.txt");
    }
    
    @After
    public void cleanUp(){
        new File("categoriesTest.txt").delete();
    }
}
