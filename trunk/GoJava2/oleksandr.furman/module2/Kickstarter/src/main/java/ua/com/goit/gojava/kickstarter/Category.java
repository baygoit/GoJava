package ua.com.goit.gojava.kickstarter;

public class Category {
	private String name;
	private int id; 
	
	public Category() {
		
	}
	
	public Category(int id) {
		this.id = id;
	}
	
	public Category(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {		
		return name; 
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
