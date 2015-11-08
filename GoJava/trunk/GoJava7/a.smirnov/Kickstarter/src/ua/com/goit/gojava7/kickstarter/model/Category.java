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
		// OLEG why we selected equals with instanceof?
		// OLEG WTF hashCode?
		if (obj != null && obj instanceof Category) {
			Category category = (Category) obj;
			// OLEG this?
			return this.name.equals(category.getName());
		}
		return false;
	}

	@Override
	public String toString() {
		// OLEG not StringBuilder?
		// OLEG why we use getter here?
		return "Category: " + getName();
	}

}
