package mainkick;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.FileNotFoundException;

import org.junit.Test;

public class test1Mock {
	
	@Test
    public void simpleMocking2() throws FileNotFoundException{
		Category category = mock(Category.class);
		Projects projects = new Projects();
		category.showAllProjectInCategory(2, projects);
		verify(category).showAllProjectInCategory(2, projects);
	}
}
