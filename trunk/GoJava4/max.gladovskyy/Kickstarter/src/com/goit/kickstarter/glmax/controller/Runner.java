package com.goit.kickstarter.glmax.controller;

import java.util.*;

import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.PaymentVariant;
import com.goit.kickstarter.glmax.enteties.Project;
import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.pages.Page;
import com.goit.kickstarter.glmax.pages.PageFactory;
import com.goit.kickstarter.glmax.view.*;

public class Runner {
	private DataSource dataSource;
	private PageFactory pageFactory;
	private Input reader;
	private Output printer;

	public Runner(DataSource dataSource, View view) {
		this.dataSource = dataSource;
		this.pageFactory = new ConsolePageFactory(dataSource);
		this.reader = new ConsoleIn();
		this.printer = new ConsoleOut();

	}

	public void run() {
		Page currentPage = initManePage();
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


	private Page initManePage() {
		Page result = pageFactory.getPage(Position.Main, dataSource.getSomeQuote());
		ArrayList<Page> childPages;
		for (Category category : dataSource.getCategories()) {
			childPages.add(pageFactory.getPage(Position.Category, category));
		}
		result.addChildPages(childPages);
		return result;
	}

}
