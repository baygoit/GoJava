package vadyazakusylo.kickstarter.controller;

import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.model.Category;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.model.Project;

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

	public void setCategoryChosen(Category category) {
		model.setCategoryChosen(category);
	}

	public void setProjectChosen(Project project) {
		model.setProjectChosen(project);
	}

	public void setCurrentMoney(double money) {
		model.setCurrentMoney(money);
	}

	public void setQuestion(String question) {
		model.setQuestion(question);
	}
}
