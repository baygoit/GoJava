package ua.com.goit.gojava.andriidnikitin;

public class Category {
	
	private Integer id = 0;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String name;
	
	public Category() {
	}

	protected Category(Integer id, String name) {
		this.id = id;
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
