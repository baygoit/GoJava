package kickstarter.engine;

import kickstarter.interfaces.display.CategoriesDisplay;
import kickstarter.interfaces.display.Display;

public class Category implements Data {
	public static Display<Category> DISPLAY = new CategoriesDisplay();
	
	private static int count = 0;

	public static final Category EXIT = new Category("EXIT");

	private int id;
	private String name;

	public Category(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.id = count++;
		this.name = name;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
