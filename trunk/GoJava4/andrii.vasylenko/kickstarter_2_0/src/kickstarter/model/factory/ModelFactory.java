package kickstarter.model.factory;

import static kickstarter.control.State.*;

import java.util.List;

import kickstarter.control.State;
import kickstarter.exception.UnknownStateException;
import kickstarter.model.CategoriesModel;
import kickstarter.model.ErrorModel;
import kickstarter.model.Model;
import kickstarter.model.ProjectModel;
import kickstarter.model.ProjectsModel;
import kickstarter.model.QuoteModel;
import kickstarter.model.StartModel;
import kickstarter.model.TheEndModel;
import kickstarter.model.storage.Storage;

public class ModelFactory implements AbstractModelFactory {
	private Storage storage;

	public ModelFactory(Storage storage) {
		this.storage = storage;
	}

	@Override
	public Model getInstance(State state, List<Object> parameters) throws UnknownStateException {
		if (state == START) {
			return new StartModel();
		} else if (state == QUOTE) {
			return new QuoteModel(storage);
		} else if (state == CATEGORIES) {
			return new CategoriesModel(storage);
		} else if (state == PROJECTS) {
			return new ProjectsModel(storage, parameters);
		} else if (state == PROJECT) {
			return new ProjectModel(parameters);
		} else if (state == ERROR) {
			return new ErrorModel();
		} else if (state == THE_END) {
			return new TheEndModel();
		}
		throw new UnknownStateException("no such state");
	}
}
