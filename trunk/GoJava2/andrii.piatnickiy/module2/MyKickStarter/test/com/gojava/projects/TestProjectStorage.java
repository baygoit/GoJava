package com.gojava.projects;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class TestProjectStorage {
    ProjectStorage projectStorage = getProjectStorage();

            
            
    abstract ProjectStorage getProjectStorage();
    
    
    @Test
    public void shouldProgectList_WhenAddProgectList() {
        projectStorage.add("name", "desc", 1, 1, 1, "projectHistory",
                "linkOnvideo", "questionsAndAnswers", 1);
        Project actual = projectStorage.getProject(0);
        assertEquals("name desc 1 1 1 projectHistory linkOnvideo questionsAndAnswers 1", actual.toString());
    }
    
////    @Test TODO спросить как такое делать.
////    public void shouldProgecttList_WheNoProgectList() {
////        ProjectStorage projectStorage = new ProjectStorage();
////        assertNull(projectStorage.getProject(0));
////    }
//    
//    @Test
//    public void shouldAllProgects_WhenGetAllToString() {
//        projectStorage.add("name", "desc", 1, 1, 1, "categoryId",
//                "linkOnvideo", "questionsAndAnswers", 1);
//        projectStorage.add("name2", "desc2", 2, 2, 2, "categoryId2",
//                "linkOnvideo2", "questionsAndAnswers2", 2);
//        String actual = projectStorage.getAllToString(1);
//        assertEquals("1) Project Name: name\nDescription: desc\nNeed Sum: 1\nCurrent Sum: 1\nDays Left: 1\n\n", actual);
//    }  
//    @Test
//    public void shouldAdditionalFields_WhenGetAdditionalProjectFields() {
//        projectStorage.add("name", "desc", 1, 1, 1, "categoryId",
//                "linkOnvideo", "questionsAndAnswers", 1);
//        String actual = projectStorage.getAdditionalProjectFields(projectStorage.getProject(0));
//        assertEquals("ProjectHistory: categoryId\nLinkOnvideo: linkOnvideo\nQuestions and answers: questionsAndAnswers\n", actual);
//    }  
//    @Test
//    public void shouldGetSpecificProject_WhenGetSpecificProjectToString() {
//        projectStorage.add("name", "desc", 1, 1, 1, "categoryId",
//                "linkOnvideo", "questionsAndAnswers", 1);
//        String actual = projectStorage.getSpecificProjectToString(1, 1);
//        assertEquals("Project Name: name\nDescription: desc\nNeed Sum: 1\nCurrent Sum: 1\nDays Left: 1\nProjectHistory: categoryId\nLinkOnvideo: linkOnvideo\nQuestions and answers: questionsAndAnswers\n\n", actual);
//    }  
//    
    @Test
    public void shouldGetProgect_WhenGetSpecificProject() {
        projectStorage.add("name", "desc", 1, 1, 1, "categoryId",
                "linkOnvideo", "questionsAndAnswers", 1);
        Project actual = projectStorage.getSpecificProject(1, 1);
        assertEquals(projectStorage.getProject(0), actual);
    }  
}
