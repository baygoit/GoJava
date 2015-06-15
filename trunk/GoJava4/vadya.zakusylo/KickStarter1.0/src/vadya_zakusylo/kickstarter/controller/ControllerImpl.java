package vadya_zakusylo.kickstarter.controller;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.model.Project;
import vadya_zakusylo.kickstarter.view.factory.State;

public class ControllerImpl implements Controller {
	private Model model;
	private State state;

	public ControllerImpl(Model model) {
		this.model = model;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public void setCategory(Category category) {
		model.setCategory(category);
	}

	@Override
	public void setProject(Project project) {
		model.setProject(project);
	}

	@Override
	public void setCurrentMoney(double money) {
		model.setCurrentMoneySynchronized(money);
	}

	@Override
	public void setQuestion(String question) {
		model.setQuestion(question);
	}
}
