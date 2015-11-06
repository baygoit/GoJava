package ua.com.goit.gojava7.kickstarter.model;

public class Category {
	
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Category) {
			Category category = (Category) obj;
			return this.name.equals(category.getName());
		}
		return false;
	}
}
