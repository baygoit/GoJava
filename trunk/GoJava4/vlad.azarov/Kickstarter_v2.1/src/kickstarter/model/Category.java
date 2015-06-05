package kickstarter.model;

public class Category {
	private String name;
	private int id;
	private static int count = 0;

	public Category(String name) {
		this.name = name;
		this.id = ++count;
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
	
	@Override
	public String toString() {
		return name;
	}
}
