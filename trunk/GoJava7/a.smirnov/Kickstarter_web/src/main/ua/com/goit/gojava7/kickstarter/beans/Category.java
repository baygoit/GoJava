package main.ua.com.goit.gojava7.kickstarter.beans;

public class Category {
	private int uniqueID;
	private String name;

	public int getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id : " + uniqueID + ", name : " + name;
	}
}
