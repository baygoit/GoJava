package com.gojava.projects;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProjectStorage {
    ProjectStorage projectStorage = new ProjectStorage();

    @Test
    public void shouldProgecttList_WhenAddProgectList() {
        ProjectStorage projectStorage = new ProjectStorage();
        projectStorage.add("name", "desc", 1, 1, 1, "categoryId",
                "linkOnvideo", "questionsAndAnswers", 1);
        Project project = projectStorage.getProject(0);
        assertEquals("name desc 1 1 1 categoryId linkOnvideo questionsAndAnswers 1", project.toString());
    }
    
//    @Test TODO спросить как такое делать.
//    public void shouldProgecttList_WheNoProgectList() {
//        ProjectStorage projectStorage = new ProjectStorage();
//        assertNull(projectStorage.getProject(0));
//    }
}
