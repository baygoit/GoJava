package com.goit.kickstarter.glmax.controller;

import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.pages.Page;
import com.goit.kickstarter.glmax.pages.PageFactory;
import com.goit.kickstarter.glmax.view.*;

public class Runner {
	private DataSource dataSource;
	private PageFactory pageFactory;
	private Input reader;
	private Output printer;

	public Runner(DataSource dataSource) {
		this.dataSource = dataSource;
		this.pageFactory = new ConsolePageFactory(dataSource);
		this.reader = new ConsoleIn();
		this.printer = new ConsoleOut();
	}

	public void run() {
		Page currentPage = pageFactory.getPage(Position.Main, dataSource.getSomeQuote());
		currentPage.show(printer);
		int userChois;
		
		while (true) {
			userChois = reader.getValidatedUserChois(currentPage.getMenuVariantsAmount());
			if (userChois == 0) {
				currentPage.getParentPage().show(printer);
			} else {
				currentPage.getChildPage(userChois).show(printer);
			}
		}
	}
}