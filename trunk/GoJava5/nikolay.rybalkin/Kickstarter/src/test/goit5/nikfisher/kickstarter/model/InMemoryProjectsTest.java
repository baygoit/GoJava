package goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;

public class InMemoryProjectsTest extends ProjectsTest {

    @Override
    Projects getProjects() {
        return new InMemoryProjects();
    }
}