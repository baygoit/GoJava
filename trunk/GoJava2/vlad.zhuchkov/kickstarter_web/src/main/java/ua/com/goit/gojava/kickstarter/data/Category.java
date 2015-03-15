package ua.com.goit.gojava.kickstarter.data;

public class Category {

	private int id;
	private String name;
	public Category(int id,String name){
		this.id=id;
		this.name=name;
	}
	public Category(int id) {
	this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
