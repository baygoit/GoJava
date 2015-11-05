package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category: " + getName();
	}

}
