package ua.com.goit.gojava7.kickstarter.domain;

public class Category {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Category: " + name;
	}
}