package ua.com.goit.gojava7.kickstarter.domain;

public class Category {
	private final int id;
	private String name;

	public Category(String name, int categoryId) {
		setName(name);
		this.id = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
