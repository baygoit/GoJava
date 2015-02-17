package ua.com.goit.gojava.andriidnikitin.model;

public class GoodType {
	
	private Integer id;
	private String name;
	private GoodType parent;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public GoodType getParent() {
		return parent;
	}
	
	public void setParent(GoodType parent) {
		this.parent = parent;
	}
	
}
