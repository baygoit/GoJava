package vadya_zakusylo.kickstarter.controller;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Project;
import vadya_zakusylo.kickstarter.view.factory.State;

public interface Controller {

	public State getState();

	public void setState(State state);

	public void setCategory(Category category);

	public void setProject(Project project);

	public void setCurrentMoney(double money);

	public void setQuestion(String question);

}
