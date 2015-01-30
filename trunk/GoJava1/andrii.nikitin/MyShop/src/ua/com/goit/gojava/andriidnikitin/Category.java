package ua.com.goit.gojava.andriidnikitin;

public class Category {
	private String name;
	
	private Integer id;
	
	public Category() {
	}

	protected Category(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}
	
	public Integer getId() {
		return id;
	}

	public Category setId(Integer id) {
		this.id = id;
		return this;
	}

	@Override
	public String toString(){
		return name + " [id: " + id.toString() + " ]";
	}
	
	
}