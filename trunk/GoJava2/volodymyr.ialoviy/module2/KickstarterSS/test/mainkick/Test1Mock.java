package mainkick;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.FileNotFoundException;

import model.Categories;
import model.Projects;
import model.ProjectsFromFile;

import org.junit.Test;

public class Test1Mock {
	
	@Test
    public void simpleMocking2() throws FileNotFoundException{
		Categories categories = mock(Categories.class);
		Projects projects = new ProjectsFromFile();
		categories.showAllProjectInCategory(2, projects);
		verify(categories).showAllProjectInCategory(2, projects);
	}
}
