package com.gojava.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;

public class Level3Test {
    
    ProjectStorage projectStorage = new ProjectStorage();
    CategoryStorage categoryStorage =  new CategoryStorage();
    Menu menu = new Menu(categoryStorage, projectStorage, new ConsoleIO());

     @Test
     public void shouldGetOneProjects_WhenDisplayMySelf() {
         menu.setCategoryPosition(1);
         projectStorage.add("test1", "description1", 1, 1, 1, "projectHistory1",
                 "linkOnvideo1", "questionsAndAnswers1", 1);
         String actual = menu.level3.displayMySelf(1);
         assertEquals(
                 "Project Name: test1\nDescription: description1\nNeed Sum: 1\nCurrent Sum: 1\nDays Left: 1\nProjectHistory: projectHistory1\nLinkOnvideo: linkOnvideo1\nQuestions and answers: questionsAndAnswers1\n\n",
                 actual);
     }
     
   @Test
   public void shouldGetNoProjects_WhenDisplayMySelf() {
   String actual = menu.level3.displayMySelf(1);
   assertEquals("", actual);
   }
     
     
}
