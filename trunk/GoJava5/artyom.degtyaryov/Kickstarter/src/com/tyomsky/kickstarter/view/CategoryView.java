package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Entity;

public class CategoryView extends EntityView {

	public CategoryView(Entity entity) {
		super(entity);
		viewType = ViewTypes.Category;
	}

	@Override
    protected void prepareLayout() {
		Category category = (Category) entity;
		layout.add("You are in category: " + category.getName());
		layout.add("");
		layout.add("Please choose project:");
		fillMenu();
		layout.add("");
		layout.add("0) Exit");

	}

}
