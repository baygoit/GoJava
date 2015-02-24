package ua.com.goit.gojava2.vova.kickstarter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.FileNotFoundException;

import org.junit.Test;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsFromFile;

public class Test1Mock {
	
	@Test
    public void simpleMocking2() throws FileNotFoundException{
		Categories categories = mock(Categories.class);
		Projects projects = new ProjectsFromFile();
		categories.showAllProjectInCategory(2, projects);
		verify(categories).showAllProjectInCategory(2, projects);
	}
}
