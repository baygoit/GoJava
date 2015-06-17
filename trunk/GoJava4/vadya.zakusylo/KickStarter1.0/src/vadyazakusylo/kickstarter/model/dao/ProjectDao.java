package vadyazakusylo.kickstarter.model.dao;

import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public abstract class ProjectDao {

	public abstract double getCurrenMoney(String nameProject) throws GettingDateException;

	public abstract void setCurrentMoney(double money, String nameProject);

	public abstract void setQuestion(String question, String name);

}