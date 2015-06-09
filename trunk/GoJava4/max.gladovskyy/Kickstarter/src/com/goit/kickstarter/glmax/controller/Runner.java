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
		this.pageFactory = new ConsolePageFactory(dataSource);
		this.reader = new ConsoleIn();
		this.printer = new ConsoleOut();
		this.dataSource = dataSource;
	}

	public void run() {
		Page currentPage = pageFactory.getPage(Position.Main, dataSource.getSomeQuote());
		Page nextPage = null;
		int userChois;
		
		while (true) {
			currentPage.show(printer);
			userChois = reader.getValidatedUserChois(currentPage.getMenuVariantsAmount());
			nextPage = currentPage.getChildPage(userChois);
			pageFactory.prepareNextPage(nextPage);
			
		}
	}
}