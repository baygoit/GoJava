package ua.dborisenko.kickstarter;

import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Project;

import static org.junit.Assert.*;

public class ProjectTest {

    @Test
    public void setGetIdTest() {
        Project project = new Project();
        project.setId(-1);
        assertTrue(-1 == project.getId());
    }

    @Test
    public void setGetNameTest() {
        Project project = new Project();
        project.setName("testname");
        assertTrue("testname" == project.getName());
    }

    @Test
    public void setGetDescriptionTest() {
        Project project = new Project();
        project.setDescription("testdescription");
        assertTrue("testdescription" == project.getDescription());
    }

    @Test
    public void setGetHistoryTest() {
        Project project = new Project();
        project.setHistory("testhistory");
        assertTrue("testhistory" == project.getHistory());
    }

    @Test
    public void setGetRequiredSumTest() {
        Project project = new Project();
        project.setRequiredSum(10);
        assertTrue(10 == project.getRequiredSum());
    }

    @Test
    public void setGetCollectedSumTest() {
        Project project = new Project();
        project.setCollectedSum(100);
        assertTrue(100 == project.getCollectedSum());
    }

    @Test
    public void setGetDaysLeftTest() {
        Project project = new Project();
        project.setDaysLeft(200);
        assertTrue(200 == project.getDaysLeft());
    }

    @Test
    public void setGetVideoUrlTest() {
        Project project = new Project();
        project.setVideoUrl("qqq");
        assertEquals("qqq", project.getVideoUrl());
    }

    @Test
    public void setGetDiscussionUrlTest() {
        Project project = new Project();
        project.setDiscussionUrl("qqqwww");
        assertEquals("qqqwww", project.getDiscussionUrl());
    }
}
