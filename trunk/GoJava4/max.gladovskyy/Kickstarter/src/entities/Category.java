package entities;

public class Category {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
