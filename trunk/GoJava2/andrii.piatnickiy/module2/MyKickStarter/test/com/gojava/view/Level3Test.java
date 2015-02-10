package com.gojava.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.projects.ProjectStorage;
import com.gojava.view.Level3;

public class Level3Test {

    ProjectStorage projectStorage = new ProjectStorage();

     @Test
     public void shouldGetNoProjects_WhenDisplayMySelf() {
     Level3 level3 = new Level3(projectStorage);
     String actual = level3.displayMySelf(1, 1);
     assertEquals("", actual);
     }

    @Test
    public void shouldGetOneProjects_WhenDisplayMySelf() {
        int a = 5;
        Level3 level3 = new Level3(projectStorage);
        projectStorage.add("test1", "description1", 1, 1, 1, "projectHistory1",
                "linkOnvideo1", "questionsAndAnswers1", 1);
        String actual = level3.displayMySelf(1, 1);
        assertEquals(
                "Project Name: test1\nDescription: description1\nNeed Sum: 1\nCurrent Sum: 1\nDays Left: 1\nProjectHistory: projectHistory1\nLinkOnvideo: linkOnvideo1\nQuestions and answers: questionsAndAnswers1\n\n",
                actual);
    }
}
