package vadyazakusylo.kickstarter.model.dao;

import vadyazakusylo.kickstarter.model.Project;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public interface ProjectDao {

	Project getProject(String projectName);

	double getCurrenMoney(String nameProject) throws GettingDateException;

	void setCurrentMoney(double money, String nameProject);

	void setQuestion(String question, String name);

}