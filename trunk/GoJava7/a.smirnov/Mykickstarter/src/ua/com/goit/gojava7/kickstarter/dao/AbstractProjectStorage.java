package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public abstract class AbstractProjectStorage implements Storage<Project> {

	public abstract List<Project> getProjectsFromCategory(Category category);

}
