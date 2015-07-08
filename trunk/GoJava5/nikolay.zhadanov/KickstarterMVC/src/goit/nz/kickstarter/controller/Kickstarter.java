package goit.nz.kickstarter.controller;

import goit.nz.kickstarter.DataStorage;
import goit.nz.kickstarter.model.Model;
import goit.nz.kickstarter.model.ModelFactory;
import goit.nz.kickstarter.util.ConsoleListener;
import goit.nz.kickstarter.view.Displayable;
import goit.nz.kickstarter.view.ViewFactory;

public class Kickstarter {
	private DataStorage storage;
	private Navigator navigator;
	private ConsoleListener listener;
	private ViewFactory viewFactory;
	private ModelFactory modelFactory;

	public Kickstarter(DataStorage storage) {
		this.storage = storage;
		this.storage.uploadData();
		navigator = new Navigator();
		listener = new ConsoleListener(navigator);
		viewFactory = new ViewFactory();
		modelFactory = new ModelFactory();
	}

	public void run() {
		Model quote = modelFactory.getModel(storage, navigator.getLayer(), navigator.getSelection());
		Displayable quoteView = viewFactory.getView(quote);
		quoteView.update();
		navigator.skip();
		do {
			Model model = modelFactory.getModel(storage, navigator.getLayer(), navigator.getSelection());
			Displayable view = viewFactory.getView(model);
			view.update();
			listener.listen(model.size());
		} while (!navigator.isExit());
	}
}
