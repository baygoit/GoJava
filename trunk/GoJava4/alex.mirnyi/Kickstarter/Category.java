package Kickstarter;

public class Category {
	private int id;
	private String name;
	
	Category(int id, String name) {
		this.setId(id);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}