package vadya_zakusylo.kickstarter.model.dao;

import java.util.List;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Project;

public interface ProjectsDao {

	List<Project> getProjectsList(Category category);

	double getCurrenMoney(String nameProject);

	void setCurrentMoney(double money, String nameProject);

	void setQuestion(String question, String name);

}