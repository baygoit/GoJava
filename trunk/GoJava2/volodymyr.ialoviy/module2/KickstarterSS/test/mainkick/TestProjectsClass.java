package mainkick;

import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import org.junit.Test;

public class TestProjectsClass {

	@Test
    public void should1_when() throws FileNotFoundException{
		Projects projects = new Projects();
		projects.writeAllProjects();
//		Project project = new Project();
		String s = projects.showProjectFull(2);
		assertTrue(s.equals("projectID = 3\n"
				+ " projectName: Progect-3\n"
				+ " shortDescription: shortDescription-3\n"
				+ " fullDescription: fullDescription-3\n"
				+ " foto: foto-3\n"
				+ " link: Link\n"
				+ " howMuchNeeded = 1000\n"
				+ " howMuchCollected = 10\n"
				+ " howMuchRemaining = 990"));
    }
}
