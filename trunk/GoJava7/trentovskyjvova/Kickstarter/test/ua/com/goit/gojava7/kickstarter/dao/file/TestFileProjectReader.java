package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class TestFileProjectReader {
	private File testProjectsFile;
	private FileProjectReader fileProjectReader;

	@Test
	public void testGetProjects() {
		testProjectsFile = new File("./resources/projects.csv");
		fileProjectReader = new FileProjectReader(testProjectsFile);
		assertThat(fileProjectReader.getProjects(1).size(), is(2));
	}

	@Test
	public void testGetProjectsNotProjectsInFile() {
		testProjectsFile = new File("./resources/noprojects.csv");
		fileProjectReader = new FileProjectReader(testProjectsFile);
		assertThat(fileProjectReader.getProjects(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetProjectsNoProjectsFile() {
		testProjectsFile = new File("./resources/notExistentProjects.csv");
		fileProjectReader = new FileProjectReader(testProjectsFile);
		fileProjectReader.getProjects(0);
	}

	@Test
	public void testGetProject() {
		testProjectsFile = new File("./resources/projects.csv");
		fileProjectReader = new FileProjectReader(testProjectsFile);
		assertThat(fileProjectReader.getProject(2).getName(),
				is("Second project"));
	}

	@Test
	public void testSize() {
		testProjectsFile = new File("./resources/projects.csv");
		fileProjectReader = new FileProjectReader(testProjectsFile);
		assertThat(fileProjectReader.size(), is(3));
	}

}
