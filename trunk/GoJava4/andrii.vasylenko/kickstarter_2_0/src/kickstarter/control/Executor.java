package kickstarter.control;

import java.util.List;

import kickstarter.exception.NoResultException;
import kickstarter.exception.ProcessedException;
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

	public void exequte() throws ProcessedException {
		executed = false;
		showThePage();
		StringBuilder input = new StringBuilder();
		int itemNumber = choiceItem(input);
		setResult(itemNumber, input.toString());
	}

	public boolean isExecuted() {
		return executed;
	}

	public State getDirection() throws NoResultException {
		if (!isExecuted()) {
			throw new NoResultException("not executed yet");
		}
		return direction;
	}

	public List<Object> getParameters() throws NoResultException {
		if (!isExecuted()) {
			throw new NoResultException("not executed yet");
		}
		return parameters;
	}

	private void showThePage() throws ProcessedException {
		view.view(model.getData());
	}

	private void setResult(int itemNumber, String input) throws ProcessedException {
		direction = view.getDirection(itemNumber);
		parameters = model.getParameters(itemNumber, input);
		executed = true;
	}

	private int choiceItem(StringBuilder input) throws ProcessedException {
		if (model.showOnly()) {
			return 0;
		}
		return view.choiceItem(input);
	}

}
