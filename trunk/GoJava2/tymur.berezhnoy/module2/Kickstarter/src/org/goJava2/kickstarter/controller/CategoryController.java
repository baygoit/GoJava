package org.goJava2.kickstarter.controller;

import java.util.List;

import org.goJava2.kickstarter.behavior.ControllerBehavior;
import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.factory.StorageFactory;

public class CategoryController implements ControllerBehavior<Integer> {
	
	@Override
	public List<Category> passContentToView() {
		return StorageFactory.getCategoryStorage().getContent();
	}
	
	@Override
	public Category passSpecificContentToView(Integer t) {
		return StorageFactory.getCategoryStorage().getSpecificContent(t - 1);
	}
}