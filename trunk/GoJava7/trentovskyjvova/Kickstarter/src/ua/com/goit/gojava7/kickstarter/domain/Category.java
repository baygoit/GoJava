package ua.com.goit.gojava7.kickstarter.domain;

public class Category {
	private String name;

	public Category(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
