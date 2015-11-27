package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

public class TestFileProjectReader {
	private File testQuotesFile;
	private FileProjectReader fileProjectReader;

	@Test
	public void testGetProjects1() {
		testQuotesFile = new File("./resources/projects.csv");
		fileProjectReader = new FileProjectReader(
				testQuotesFile);
		assertThat(fileProjectReader.getProjects(1).size(), is(2));
	}

	@Test(expected = IllegalStateException.class)
	public void testGetProjectsNotProjectsInFile() {
		testQuotesFile = new File("./resources/noProjects.csv");
		fileProjectReader = new FileProjectReader(
				testQuotesFile);
		fileProjectReader.getProjects(1);
	}

	@Test(expected = IllegalStateException.class)
	public void testGetProjectsNoProjectsFile() {
		testQuotesFile = new File("./resources/notExistentProjects.csv");
		fileProjectReader = new FileProjectReader(
				testQuotesFile);
		fileProjectReader.getProjects(0);
	}
}
