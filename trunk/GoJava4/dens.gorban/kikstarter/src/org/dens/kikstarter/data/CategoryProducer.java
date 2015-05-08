package org.dens.kikstarter.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CategoryProducer {
	
	private List<Category> categories = new ArrayList<>();
	
	public CategoryProducer() {
		Category category = new Category("Sport", "This is active sportware category");
		category.addProject(new Project("New Footbol gloves", "this project is going to create new enhanced glo"
				+ "ves", BigDecimal.valueOf(100)));
		categories.add(category);
		
		category = new Category("Films", "This is movies category");
		category.addProject(new Project("New Footbol filmez", "this project is going to show new enhanced glo"
				+ "ves", BigDecimal.valueOf(200)));
		categories.add(category);
		
		category = new Category("Programming", "This is it category");
		category.addProject(new Project("New Footbol programm", "this project is going to create a programm new enhanced glo"
				+ "ves", BigDecimal.valueOf(100)));
		categories.add(category);
		
		category = new Category("Advanture", "This is Advanture category");
		category.addProject(new Project("New Advanture programm", "this project is going to create a programm new enhanced glo"
				+ "ves", BigDecimal.valueOf(100)));
		categories.add(category);
		
	}

	public List<Category> getCategories() {
		return categories;
	}

	
}
