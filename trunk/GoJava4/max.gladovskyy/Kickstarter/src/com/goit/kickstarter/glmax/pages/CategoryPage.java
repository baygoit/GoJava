package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Entetie;

public class CategoryPage extends Page {

	public CategoryPage(Entetie entetie) {
		super(entetie);
	}

	@Override
	protected void prepareFormatedPage() {
		Category category = (Category) entetie;
		formatedPage.add("You in category: " + category.getName());
		formatedPage.add("");
		formatedPage.add("Plese choose project from list below:");
		fillMenu();
		formatedPage.add("");
		formatedPage.add("0) Exit");

	}

}
