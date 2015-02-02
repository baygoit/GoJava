package org.kudryavtsev.kickstarter.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Project;

public class ProjectTest {

    @Test
    public void ProjectToString() {
        Project project = new Project("TestProject", "TestDescription", 100, 100, 100);
        assertEquals("TestProject; TestDescription; funded: 100; pledged: 100; days to go: 100",
                project.toString());
    }

    @Test
    public void ProjectToStringFull() {
        Project project = new Project("TestProject", "TestDescription", 1000, 100, 101);
        assertEquals(
                "TestProject; TestDescription; funded: 1000; pledged: 100; days to go: 101\nFull description: Just long description\nHistory: History of the project\nVideo: Link to video with demo\nFAQ: Frequently Asked Questions",
                project.toStringFull());
    }

}
