package goit.nz.kickstartermvc.test.model;

import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.test.MockStorage;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectModelTest {

	@Test
	public void whenUpdateThenModelIsUpdated() {
		MockStorage storage = new MockStorage();
		storage.init();

		ProjectModel model = new ProjectModel();
		model.update(storage.getProjects(
				storage.getCategories().get(1).getName()).get(0));
		String expected = "name1";
		String actual = model.getProject().getName();
		assertEquals(expected, actual);
	}

}
