package com.gojava.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;

public class TestMenu {
    Menu menu = new Menu(new CategoryStorage(), new ProjectStorage(), null);
    @Test
    public void shouldLevel_WhenGetCurrentLevel(){
        int currentLevelPosition = 1;
        Level actual = menu.getCurrentLevel();
        Level1 level1 = new Level1(null);
        assertTrue(level1.getPosition() == actual.getPosition());
    }
    
    @Test
    public void shoulNotAlLowed_WhenTryGoUpOutOfMenu(){
        int currentLevelPosition = 1;
        String actual =  menu.nextLevel(0);
        assertEquals("not allowed to go below this level", actual);
    }
}
