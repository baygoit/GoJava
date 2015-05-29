package kickstarter;

import kickstarter.control.Control;
import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.model.storage.Storage;
import kickstarter.view.factory.AbstractViewFactory;

public class Runner_Console_Collections {
	public static void main(String[] args) {
		Runner runner = new Runner();

		Storage storage = runner.initCollectionsStorage();
		AbstractModelFactory models = runner.initModelFactory(storage);
		AbstractViewFactory views = runner.initConsoleViewFactory();
		Control control = runner.initKickstarter(models, views);

		control.exequte();
	}
}
