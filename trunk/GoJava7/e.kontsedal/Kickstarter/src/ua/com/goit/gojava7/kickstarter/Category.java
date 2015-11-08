package ua.com.goit.gojava7.kickstarter;

public class Category {
	private int categoryId = 0;
	private String categoryName;

	public Category(String name) {
		this.categoryName = name;
		categoryId++;
	}

	public String getName() {
		return this.categoryName;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

}
