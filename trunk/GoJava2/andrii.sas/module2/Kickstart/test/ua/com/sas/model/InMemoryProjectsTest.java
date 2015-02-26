package ua.com.sas.model;

public class InMemoryProjectsTest extends ProjectsTest{

	@Override
	Projects getProjects() {
		return new InnerMemoryProjects();
	}

}
