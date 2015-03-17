package org.kudryavtsev.kickstarter.data;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Project;

public class ProjectTest {

    private static final String PROJECT_DESC = "TestProject; TestDescription; funded: 100; pledged: 100; days to go: 100";

    @Test
    public void ProjectToString() {
        Project project = creatingProject();
        assertEquals(PROJECT_DESC, project.toString());
    }

    @Test
    public void ProjectToStringFull() {
        Project project = creatingProject();
        assertEquals(
                PROJECT_DESC
                        + "\nFull description: Just long description\nHistory: History of the project\nVideo: Link to video with demo\nFAQ: Frequently Asked Questions",
                project.toStringFull());
    }

    private Project creatingProject() {
        Project project = new Project("TestProject", "TestDescription", 100, 100, 100);
        return project;
    }

}
