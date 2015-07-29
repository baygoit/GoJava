package goit5.nikfisher.kickstarter.dao;

public class InMemoryProjectsTest extends ProjectsTest{

    @Override
    Projects getProjects() {
        return new InMemoryProjects();
    }
}