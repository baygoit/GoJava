package ua.com.goit.gojava7.kickstarter.model;

public class Category {

	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object other) {
		if(!super.equals(other)) return false;
        if (this == other) return true;
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Category otherObj = (Category) other;
        return this.name == otherObj.getName();
	}
}
