package ua.com.goit.gojava.andriidnikitin;

public class Category {
	private String name;
	
	public Category() {
	}

	protected Category(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return getName();
	}
}