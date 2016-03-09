package ua.nenya.alex.project;



public class Category implements GetingNameInterface {
	private String name;
	
	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}

	
}
