package goit.nz.kickstarter.view;

import goit.nz.kickstarter.model.Model;
import goit.nz.kickstarter.util.Console;

public abstract class ConsoleView implements Displayable {
	protected StringBuilder layout;
	protected Model model;
	private Console console;
	
	public ConsoleView(Model model) {
		this.model = model;
		layout = new StringBuilder();
		console = new Console();
	}

	@Override
	public void update() {
		createLayout();
		show();
	}

	@Override
	public abstract void createLayout();

	@Override
	public void show() {
		console.write(layout.toString());		
	}
}
