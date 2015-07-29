package goit.nz.kickstartermvc.dao;

public class Category {

	private String name;
	private int id;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
