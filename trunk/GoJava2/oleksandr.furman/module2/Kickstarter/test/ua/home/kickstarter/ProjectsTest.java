package ua.home.kickstarter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Test;

public class ProjectsTest {
	@Test(expected = NullPointerException.class)
	public void shouldEmptyProjects_whenNoProjects() {
		// given
		Projects list = new Projects();

		// when
		list.getProjects(new Category("name")).get(0);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldFoundProjects_whenExistsProjectWithCategory() {
		// given
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "name1");
		jsonObject.put("description", "description1");
		jsonObject.put("goal", "51");
		jsonObject.put("daysLeft", "74");
		jsonObject.put("linksToVideo", "linksToVideo1");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("name", "name2");
		jsonObject2.put("description", "description2");
		jsonObject2.put("goal", "25");
		jsonObject2.put("daysLeft", "98");
		jsonObject2.put("linksToVideo", "linksToVideo2");
		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("name", "name3");
		jsonObject3.put("description", "description3");
		jsonObject3.put("goal", "5");
		jsonObject3.put("daysLeft", "87");
		jsonObject3.put("linksToVideo", "linksToVideo3");

		Category category1 = new Category("category1");
		Category category2 = new Category("category2");

		Projects list = new Projects();

		Project project1 = new Project(jsonObject);
		project1.setCategory(category1);

		Project project2 = new Project(jsonObject2);
		project2.setCategory(category2);

		Project project3 = new Project(jsonObject3);
		project3.setCategory(category2);

		list.add(project1);
		list.add(project2);
		list.add(project3);

		// when
		List<Project> found = list.getProjects(category2);

		// then
		assertEquals(2, found.size());

		assertSame(project2, found.get(0));
		assertSame(project3, found.get(1));
	}
}
