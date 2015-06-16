package vadya_zakusylo.kickstarter.model.dao;

public abstract class ProjectDao {

	public abstract double getCurrenMoney(String nameProject);

	public abstract void setCurrentMoney(double money, String nameProject);

	public abstract void setQuestion(String question, String name);

}