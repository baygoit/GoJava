package ua.com.scread.kickstarter;

import ua.com.scread.kickstarter.storage.InMemoryProjects;
import ua.com.scread.kickstarter.storage.Projects;

public class InMemoryProjectsTest extends ProjectsTest {

    @Override
    Projects setUp() {
        return new InMemoryProjects();
    }

}
