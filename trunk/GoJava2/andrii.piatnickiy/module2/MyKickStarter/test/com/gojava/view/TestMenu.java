package com.gojava.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;

public class TestMenu {
    
    CategoryStorage categoryStorage = new CategoryStorage();
    ProjectStorage projectStorage = new ProjectStorage();
    Menu menu = new Menu(categoryStorage, projectStorage, null);
    private void initCategories() {
        categoryStorage.add("Sport", 1);
        categoryStorage.add("Car", 2);
        categoryStorage.add("Devices", 3);
    }

    private void initProjects(ProjectStorage projectStorage) {
        projectStorage.add("Bicycle", "Bicycle description", 10000, 100, 10,
                "History", "Link on video", "Questions and answers", 1);
        projectStorage.add("BMW X3", "BMW X3 description", 30000, 3000, 300,
                "History", "Link on video", "Questions and answers", 2);
        projectStorage.add("Audi Q5", "Audi Q5 description", 40000, 400, 40,
                "History", "Link on video", "Questions and answers", 2);
        projectStorage.add("Laptop", "Laptop description", 500, 50, 50,
                "History", "Link on video", "Questions and answers", 3);
        projectStorage.add("Mobile phone", "Mobile phone description", 60, 60,
                6, "History", "Link on video", "Questions and answers", 3);
    }

    private static void initCategories(CategoryStorage categoryStorage) {

    }

     @Test
     public void shouldLevel_WhenGetCurrentLevel() {
     menu.setCurrentLevelPosition(1);
     Level actual = menu.getCurrentLevel();
     Level1 level1 = new Level1(null);
     assertTrue(level1.getPosition() == actual.getPosition());
     }
    
     @Test
     public void shoulNotAlLowed_WhenTryGoUpOutOfMenu() {
     menu.setCurrentLevelPosition(1);
     String actual = menu.nextLevel(0);
     assertEquals("not allowed to go below this level", actual);
     }
    
     @Test
     public void shoulNotAlLowed_WhenTryGoDownOutOfMenu() {
     menu.setCurrentLevelPosition(3);
     String actual = menu.nextLevel(1);
     assertEquals("not allowed to go below this level", actual);
     }

    @Test
    public void shoulGetStringFromCurrentLevel_From1LevelTo2Level() {
        initCategories();
        initProjects(projectStorage);
        menu.setCurrentLevelPosition(1);
        String actual = menu.nextLevel(1);
        assertEquals("1) Project Name: Bicycle\nDescription: Bicycle description\nNeed Sum: 10000\nCurrent Sum: 100\nDays Left: 10\n\n", actual);
    }

}
