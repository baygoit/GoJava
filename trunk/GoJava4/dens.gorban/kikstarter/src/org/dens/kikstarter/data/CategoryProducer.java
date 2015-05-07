package org.dens.kikstarter.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryProducer {
	
	private List<Category> categories = new ArrayList<>();
	
	public CategoryProducer() {
		categories.add(new Category("Sport", "This is active sportware category"));
		categories.add(new Category("Films", "This is movies category"));
		categories.add(new Category("Programming", "This is it category"));
		categories.add(new Category("Advanture", "This is Advanture category"));
	
	}

	public List<Category> getCategories() {
		return categories;
	}

	
}
