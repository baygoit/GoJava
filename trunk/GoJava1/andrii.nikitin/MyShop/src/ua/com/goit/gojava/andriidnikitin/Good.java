package ua.com.goit.gojava.andriidnikitin;

public class Good {
	
	private Integer id;	

	private String name;
	
	private Category category;	
	
	public Good() {
	}	
	
	protected Good( Integer id, String name, Category category) {
		this.id = id;	
		this.name = name;
		this.category = category;
	}	
	
	public Integer getId() {
		return id;
	}
	
	public Good setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public Good setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Category getCategory() {
		return category;
	}
	
	public Good setCategory(Category category) {
		this.category = category;
		return this;
	}
	
	@Override
	public String toString(){
		return getName() + " [id: " + id.toString() + " ]";
	}	
}
