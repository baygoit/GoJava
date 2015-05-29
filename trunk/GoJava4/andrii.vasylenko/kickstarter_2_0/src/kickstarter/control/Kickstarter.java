package kickstarter.control;

import static kickstarter.control.State.*;

import java.util.List;

import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.view.factory.AbstractViewFactory;

public class Kickstarter implements Control {
	private AbstractModelFactory models;
	private AbstractViewFactory views;
	private Executor executor;

	public Kickstarter(AbstractModelFactory models, AbstractViewFactory views) {
		this.models = models;
		this.views = views;
		this.executor = getExecutor(START);
	}

	@Override
	public void exequte() {
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
			} catch (Exception e) {
				getExecutor(ERROR).exequte();
			}
		}
	}

	private Executor getExecutor(State state) {
		return getExecutor(state, null);
	}

	private Executor getExecutor(State state, List<Object> parameters) {
		return new Executor(models.getInstance(state, parameters), views.getInstance(state));
	}
}
