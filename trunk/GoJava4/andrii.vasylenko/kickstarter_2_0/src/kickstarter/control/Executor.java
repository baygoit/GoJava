package kickstarter.control;

import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.exception.NoResultException;
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

	public void exequte() throws IncorrectInputException, CannotGetDataException {
		executed = false;
		showThePage();
		int itemNumber = choiceItem();
		setResult(itemNumber);
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

	private void showThePage() throws CannotGetDataException {
		view.view(model.getData());
	}

	private void setResult(int itemNumber) throws IncorrectInputException, CannotGetDataException {
		direction = view.getDirection(itemNumber);
		parameters = model.getParameters(itemNumber);
		executed = true;
	}

	private int choiceItem() throws IncorrectInputException {
		if (model.showOnly()) {
			return 0;
		}
		return view.choiceItem();
	}

}
