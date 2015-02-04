package mainkick;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.FileNotFoundException;
import org.junit.Test;

public class test1Mock {
	
	@Test
    public void simpleMocking2() throws FileNotFoundException{
		Categories categories = mock(Categories.class);
		categories.showAllProjectInCategory(2);
		verify(categories).showAllProjectInCategory(2);
	}
}
