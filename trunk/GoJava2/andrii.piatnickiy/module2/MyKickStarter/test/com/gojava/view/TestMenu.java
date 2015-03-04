package com.gojava.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.projects.CategoryStorage;
import com.gojava.projects.InFileCategoryStorage;
import com.gojava.projects.InFileProjectStorage;
import com.gojava.projects.InMemoryProjectStorage;
import com.gojava.projects.ProjectStorage;

public class TestMenu {
//
//    CategoryStorage categoryStorage = new FileCategoryStorage("categoriesTest.txt");
//    ProjectStorage projectStorage = new InFileProjectStorage("projectsTest.txt");
//    Menu menu = new Menu(categoryStorage, projectStorage, null);
//
//    private void initCategories() {
//        categoryStorage.add("Sport", 1);
//        categoryStorage.add("Car", 2);
//        categoryStorage.add("Devices", 3);
//    }
//
//    private void initProjects(ProjectStorage projectStorage) {
//        projectStorage.add("Bicycle", "Bicycle description", 10000, 100, 10,
//                "History", "Link on video", "Questions and answers", 1);
//        projectStorage.add("BMW X3", "BMW X3 description", 30000, 3000, 300,
//                "History", "Link on video", "Questions and answers", 2);
//        projectStorage.add("Laptop", "Laptop description", 500, 50, 50,
//                "History", "Link on video", "Questions and answers", 3);
//    }
//
//    @Test
//    public void shouldLevel_WhenGetCurrentLevel() {
//        menu.setCurrentLevelPosition(1);
//        Level actual = menu.getCurrentLevel();
//        Level1 level1 = new Level1(null);
//        assertTrue(level1.getPosition() == actual.getPosition());
//    }
////
//    @Test
//    public void shoulNotAlLowed_WhenTryGoUpOutOfMenu() throws Exception {
//        menu.setCurrentLevelPosition(1);
//        String actual = menu.nextLevel(0);
//        assertEquals("", actual);
//    }
//
//    @Test
//    public void shoulNotAlLowed_WhenTryGoDownOutOfMenu() throws Exception {
//        menu.setCurrentLevelPosition(4);
//        String actual = menu.nextLevel(1);
//        assertEquals("", actual);
//    }
//
//    @Test
//    public void shoulGetStringFromCurrentLevel_FromLevel1ToLevel2() throws Exception {
//        initCategories();
//        initProjects(projectStorage);
//        menu.setCurrentLevelPosition(1);
//        String actual = menu.nextLevel(1);
//        assertEquals(
//                "1) Project Name: Bicycle\nDescription: Bicycle description\nNeed Sum: 10000\nCurrent Sum: 100\nDays Left: 10\n\n",
//                actual);
//    }
//
//    @Test
//    public void shoulGetStringFromCurrentLevel_DownFromLevel2ToLevel3() throws Exception {
//        initCategories();
//        initProjects(projectStorage);
//        menu.setCurrentLevelPosition(2);
//        menu.setCategoryPosition(1);
//        String actual = menu.nextLevel(1);
//        assertEquals(
//                "Project Name: Bicycle\nDescription: Bicycle description\nNeed Sum: 10000\nCurrent Sum: 100\nDays Left: 10\nProjectHistory: History\nLinkOnvideo: Link on video\nQuestions and answers: Questions and answers\n\n1) Invest in the project\n2) Ask a question\n",
//                actual);
//    }
//
//    @Test
//    public void shouldLevelUp_WhenType0() throws Exception {
//        initCategories();
//        initProjects(projectStorage);
//        menu.setCurrentLevelPosition(2);
//        String actual = menu.nextLevel(0);
//        assertEquals("1) Sport\n2) Car\n3) Devices\n", actual);
//    }
//    
//    @Test
//    public void shouldLevelUp_WhenType0FromLevel3ToLevel2() throws Exception {
//        initCategories();
//        initProjects(projectStorage);
//        menu.setCurrentLevelPosition(3);
//        menu.setCategoryPosition(1);
//        String actual = menu.nextLevel(0);
//        assertEquals("1) Project Name: Bicycle\nDescription: Bicycle description\nNeed Sum: 10000\nCurrent Sum: 100\nDays Left: 10\n\n", actual);
//    }
}
