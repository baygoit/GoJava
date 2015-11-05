package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;

	public Category() {}

	public Category(String name) {
		super();
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
		return "Category [name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj instanceof Category) {
			Category category = (Category) obj;
			return category.getName().equals(name);
		}
		return false;
	}

}
