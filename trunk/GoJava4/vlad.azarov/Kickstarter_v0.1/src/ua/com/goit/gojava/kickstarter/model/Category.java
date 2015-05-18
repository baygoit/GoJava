package ua.com.goit.gojava.kickstarter.model;

public class Category {
	
	private int id;
    	private String name;
	
	
	public Category(String name, int id) {
		this.name = name;
		this.id = id;
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
			
}
