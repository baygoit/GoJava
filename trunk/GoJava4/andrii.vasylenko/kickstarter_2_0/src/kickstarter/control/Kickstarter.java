package kickstarter.control;

import static kickstarter.control.State.*;

import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.exception.IncorrectLogicException;
import kickstarter.exception.NoResultException;
import kickstarter.exception.UnknownStateException;
import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.view.factory.AbstractViewFactory;

public class Kickstarter implements Control {
	private AbstractModelFactory models;
	private AbstractViewFactory views;
	private Executor executor;

	public Kickstarter(AbstractModelFactory models, AbstractViewFactory views) throws IncorrectLogicException {
		this.models = models;
		this.views = views;
		this.executor = getExecutor(START);
	}

	@Override
	public void exequte() throws IncorrectLogicException {
		while (true) {
			try {
				executor.exequte();
				if (executor.isExecuted()) {
					State direction = executor.getDirection();
					if (direction == EXIT) {
						return;
					}
					executor = getExecutor(direction, executor.getParameters());
				}
			} catch (IncorrectInputException | CannotGetDataException e) {
				showError();
			} catch (UnknownStateException | NoResultException e) {
				throw new IncorrectLogicException(e);
			}
		}
	}

	private void showError() throws IncorrectLogicException {
		try {
			getExecutor(ERROR).exequte();
		} catch (IncorrectInputException | CannotGetDataException e) {
			throw new IncorrectLogicException(e);
		}
	}

	private Executor getExecutor(State state) throws IncorrectLogicException {
		try {
			return getExecutor(state, null);
		} catch (UnknownStateException e) {
			throw new IncorrectLogicException(e);
		}
	}

	private Executor getExecutor(State state, List<Object> parameters) throws UnknownStateException {
		return new Executor(models.getInstance(state, parameters), views.getInstance(state));
	}
}
