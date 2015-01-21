package ua.com.goit.gojava.andriidnikitin;

public class Good {
	
	private Category category;
	
	private String name;
	
	private int id;
		
	static private int maxID = 1;
	
	public Good(Category category, String name) {
		super();
		this.category = category;
		this.name = name;
		id = maxID;
		maxID++;
	}

	public String toString(){
		return getName();
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
}
