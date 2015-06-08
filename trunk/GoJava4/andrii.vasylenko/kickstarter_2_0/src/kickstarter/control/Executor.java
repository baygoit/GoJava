package kickstarter.control;

import java.sql.SQLException;
import java.util.List;

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

	public void exequte() throws ProcessedException, SQLException {
		executed = false;
		showThePage();
		StringBuilder input = new StringBuilder();
		int itemNumber = choiceItem(input);
		setResult(itemNumber, input.toString());
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

	private void showThePage() throws ProcessedException, SQLException {
		view.view(model.getData());
	}

	private void setResult(int itemNumber, String input) throws ProcessedException, SQLException {
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
