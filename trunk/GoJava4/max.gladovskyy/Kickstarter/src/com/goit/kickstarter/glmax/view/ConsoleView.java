package com.goit.kickstarter.glmax.view;

import com.goit.kickstarter.glmax.controller.*;
import com.goit.kickstarter.glmax.pages.*;

public class ConsoleView implements View {
	private Runner runner;
	private PageFactory pageFactory;
	private Input reader;
	private Output output;

	public ConsoleView(Runner runner) {
		this.runner = runner;
		this.pageFactory = new ConsolePageFactory();
		this.reader = new ConsoleIn();
		this.output = new ConsoleOut();
	}

	@Override
	public void show(Position position) {
		Page page = pageFactory.getPage(position, runner);
		page.print(output);
		
		int variantsAmount = runner.getVariantsAmount();
		runner.process(reader.getFromUser(variantsAmount));
	}

}
