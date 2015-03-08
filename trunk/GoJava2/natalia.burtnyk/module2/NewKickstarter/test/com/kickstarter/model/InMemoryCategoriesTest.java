package com.kickstarter.model;

public class InMemoryCategoriesTest extends CategoriesTest {

	@Override
	Categories getCategories() {
		return new InMemoryCategories();
	}

}
