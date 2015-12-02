package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class MemoryCategoryReader {

	public List<Category> readCategories() {
		List<Category> categories = new ArrayList<Category>();

		Category category = new Category();
		category.setName("Movie");

		Project project = new Project("New funnny movie", "The movie about new funny story", 5000000L, 30);
		project.setHistory("No history");
		project.setVideoUrl("https://example.com/video.mp4");
		project.setQuestionsAndAnswers("Q: What is our real content? A: Currently, we are waiting for it");
		category.getProjects().add(project);

		project = new Project("Not funnny movie", "The movie about sad story", 500000L, 14);
		category.getProjects().add(project);

		categories.add(category);
		// cut
		category = new Category();
		category.setName("Dances");

		project = new Project("Dance with me", "It's about tango", 50000L, 30);
		category.getProjects().add(project);

		project = new Project("Waltz", "It's about waltz", 20000L, 14);
		category.getProjects().add(project);

		categories.add(category);
		// cut
		category = new Category();
		category.setName("Food");

		project = new Project("Prosciutto ", "Italian ham", 5000L, 10);
		category.getProjects().add(project);

		project = new Project("Popato", "Belarussian potato", 200L, 5);
		category.getProjects().add(project);

		categories.add(category);

		return categories;
	}
}
