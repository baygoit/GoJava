package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class ProjectDaoFileImplTest {
	private File testProjectsFile;
	private ProjectDaoFileImpl projectDaoFileImpl;

	@Test
	public void testGetProjects() {
		testProjectsFile = new File("./resources/projects.csv");
		projectDaoFileImpl = new ProjectDaoFileImpl(testProjectsFile);
		assertThat(projectDaoFileImpl.getProjects(1).size(), is(2));
	}

	@Test
	public void testGetProjectsNotProjectsInFile() {
		testProjectsFile = new File("./resources/noprojects.csv");
		projectDaoFileImpl = new ProjectDaoFileImpl(testProjectsFile);
		assertThat(projectDaoFileImpl.getProjects(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetProjectsNoProjectsFile() {
		testProjectsFile = new File("./resources/notExistentProjects.csv");
		projectDaoFileImpl = new ProjectDaoFileImpl(testProjectsFile);
		projectDaoFileImpl.getProjects(0);
	}

	@Test
	public void testGetProject() {
		testProjectsFile = new File("./resources/projects.csv");
		projectDaoFileImpl = new ProjectDaoFileImpl(testProjectsFile);
		assertThat(projectDaoFileImpl.getProject(2, 1).getName(),
				is("Second project"));
	}

	@Test
	public void testSize() {
		testProjectsFile = new File("./resources/projects.csv");
		projectDaoFileImpl = new ProjectDaoFileImpl(testProjectsFile);
		assertThat(projectDaoFileImpl.size(1), is(2));
	}

}
