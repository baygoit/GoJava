package vadyazakusylo.kickstarter.model.dao;

import java.util.List;

import vadyazakusylo.kickstarter.model.Category;
import vadyazakusylo.kickstarter.model.Project;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public interface ProjectsDao {

	List<Project> getProjectsList(Category category) throws GettingDateException;

}