package kickstarter.control;

import java.util.List;

import kickstarter.model.Model;
import kickstarter.view.View;

public class Executor {
	private Model model;
	private View view;
	private boolean executed;
	private State direction;
	private List<Object> parameters;

	public Executor(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void exequte() {
		executed = false;
		showThePage();
		int itemNumber = choiceItem();
		setResult(itemNumber);
	}

	public boolean isExecuted() {
		return executed;
	}

	public State getDirection() {
		if (!isExecuted()) {
			throw new IllegalStateException();
		}
		return direction;
	}

	public List<Object> getParameters() {
		if (!isExecuted()) {
			throw new IllegalStateException();
		}
		return parameters;
	}

	private void showThePage() {
		view.view(model.getData());
	}

	private void setResult(int itemNumber) {
		direction = view.getDirection(itemNumber);
		parameters = model.getParameters(itemNumber);
		executed = true;
	}

	private int choiceItem() {
		if (model.showOnly()) {
			return 0;
		}
		return view.choiceItem();
	}

}
