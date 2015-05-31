package com.goit.kickstarter.glmax.view;

import java.util.ArrayList;
import java.util.List;

import com.goit.kickstarter.glmax.controller.*;
import com.goit.kickstarter.glmax.pages.*;

public class ConsoleView implements View {
	private Runner runner;
	private PageFactory pageFactory;
	private Input reader;
	private Output output;

	public ConsoleView() {
		this.pageFactory = new ConsolePageFactory();
		this.reader = new ConsoleIn();
		this.output = new ConsoleOut();
	}

	@Override
	public void show(Position position) {
		Page page = pageFactory.getPage(position, runner);
		output.print(page.getPage());
		
		ArrayList<Integer> variantsAmount = runner.getVariantsAmount();
		runner.process(reader.getFromUser(variantsAmount));
	}

	@Override
	public int getUserAction(ArrayList<Integer> choisList) {
		return reader.getFromUser(choisList);
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

}
