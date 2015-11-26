package ua.com.goit.gojava7.kickstarter.dao.storage;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public interface ProjectStorage extends Storage<Project> {

	public default List<Project> getByCategory(String categoryName) {

		return this.getAll().stream().filter(project -> project.getCategoryName().equals(categoryName))
				.collect(Collectors.toList());
	}
	
	public Project getByNumber(int number);

}
