package ua.com.goit.gojava7.kikstarter.domain;

public class Category {

	private int uniqueID;
	private String name;

	public Category(int uniqueID, String name) {
		this.uniqueID = uniqueID;
		this.name = name;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "ID: " + uniqueID + ", Name: " + name;
	}

}
