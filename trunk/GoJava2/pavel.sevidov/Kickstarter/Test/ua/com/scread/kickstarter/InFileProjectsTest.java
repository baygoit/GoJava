package ua.com.scread.kickstarter;

import java.io.File;

import org.junit.After;

import ua.com.scread.kickstarter.storage.InFileProjects;
import ua.com.scread.kickstarter.storage.Projects;

public class InFileProjectsTest extends ProjectsTest {

    @Override
    Projects setUp() {
        return new InFileProjects("projects-test.txt");
    }
    
    @After
    public void cleanUp() {
        new File("test-projects.txt").delete();
    }

}
