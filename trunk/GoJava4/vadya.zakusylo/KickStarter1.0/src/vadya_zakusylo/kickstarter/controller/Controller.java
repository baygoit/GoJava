package vadya_zakusylo.kickstarter.controller;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.model.Project;
import vadya_zakusylo.kickstarter.view.factory.State;

public class Controller {
	private Model model;
	private State state;

	public Controller(Model model) {
		this.model = model;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setCategory(Category category) {
		model.setCategory(category);
	}

	public void setProject(Project project) {
		model.setProject(project);
	}

	public void setCurrentMoney(double money) {
		model.setCurrentMoney(money);
	}

	public void setQuestion(String question) {
		model.setQuestion(question);
	}
}
