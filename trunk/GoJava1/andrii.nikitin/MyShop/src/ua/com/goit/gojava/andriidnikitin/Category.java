package ua.com.goit.gojava.andriidnikitin;

public class Category {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString(){
		return getName();
	}
	
}
