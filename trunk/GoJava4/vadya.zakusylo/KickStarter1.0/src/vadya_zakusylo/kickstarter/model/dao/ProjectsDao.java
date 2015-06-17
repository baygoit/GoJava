package vadya_zakusylo.kickstarter.model.dao;

import java.util.List;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Project;
import vadya_zakusylo.kickstarter.model.exception.GettingDateException;

public abstract class ProjectsDao {

	public abstract List<Project> getProjectsList(Category category) throws GettingDateException;

}