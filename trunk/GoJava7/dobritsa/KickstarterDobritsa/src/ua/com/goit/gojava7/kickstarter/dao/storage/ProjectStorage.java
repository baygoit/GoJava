package ua.com.goit.gojava7.kickstarter.dao.storage;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public interface ProjectStorage extends Storage<Project> {

	public Project getByNumber(int number);

	public void updatePledged(Project project, int amount);

	public int getPledged(String projectName);

	public default List<Project> getByCategory(String categoryName) {
		return this.getAll().stream().filter(project -> project.getCategoryName().equals(categoryName))
				.collect(Collectors.toList());
	}

}
