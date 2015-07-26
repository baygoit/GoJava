package goit5.nikfisher.kickstarter.model;

public class Category {

	private String name;

	public Category(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category category = (Category) o;

		return !(name != null ? !name.equals(category.name) : category.name != null);
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
