package kickstarter.storages;

import static org.junit.Assert.*;
import kickstarter.engine.Category;
import kickstarter.engine.Project;

import org.junit.Test;

public class ProjectsStorageTest {

	private Category category = new Category("name");

	@Test
	public void shouldZeroSize_whenClearStorage() {
		ProjectsStorage storage = new ProjectsStorage();
		assertEquals(0, storage.size());
		assertTrue(storage.isEmpty());
	}

	@Test
	public void shouldCorrectValue_whenAddNewElemetnts() {
		Project project1 = new Project("name1", "description", category, 1, 1);
		Project project2 = new Project("name2", "description", category, 1, 1);
		Project project3 = new Project("name3", "description", category, 1, 1);

		ProjectsStorage storage = new ProjectsStorage();
		storage.add(project1);
		assertEquals(1, storage.size());
		storage.add(project2);
		assertEquals(2, storage.size());
		storage.add(project3);
		assertEquals(3, storage.size());
		assertFalse(storage.isEmpty());

		assertEquals(project1, storage.get(0));
		assertEquals(project2, storage.get(1));
		assertEquals(project3, storage.get(2));

		assertEquals(project1, storage.getById(project1.getId()));
		assertEquals(project2, storage.getById(project2.getId()));
		assertEquals(project3, storage.getById(project3.getId()));
	}

/*	@Test
	public void shouldCorrectSelectionValues_whenElemetntsFromDifferentCategories() {
		Project project1 = new Project("name1", "description", category, 1, 1);
		Project project2 = new Project("name2", "description", category, 1, 1);
		Project project3 = new Project("name3", "description", category, 1, 1);

		ProjectsStorage storage = new ProjectsStorage();
		storage.add(project1);
		storage.add(project2);
		storage.add(project3);

		assertEquals(storage.size(), storage.getProjectsInCategory(category).size());

		storage.add(new Project("name1", "description", new Category("OtherCategory"), 1, 1));

		assertEquals(storage.size()-1, storage.getProjectsInCategory(category).size());
	}*/

}
