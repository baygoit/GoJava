package oop;

public class Category {
	private String name;
	
	Category(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
