package ua.com.goit.gojava.andriidnikitin;

public class Good {
	
	private Category category;
	
	private String name;
	
	private int id;
			
	public Good(Category category, String name, int id) {
		super();
		this.category = category;
		this.name = name;
		this.id = id;	}

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
