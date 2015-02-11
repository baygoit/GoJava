package com.gojava.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;

public class level4Test {
    ProjectStorage projectStorage = new ProjectStorage();
    CategoryStorage categoryStorage = new CategoryStorage();
    Menu menu = new Menu(categoryStorage, projectStorage, new ConsoleIO());
    
    @Test
    public void shouldAskName_WhenLevel4DisplayMySelf() {
        String actual = menu.level4.displayMySelf(1);
        assertEquals("Please, enter your name", actual);
    }
}
