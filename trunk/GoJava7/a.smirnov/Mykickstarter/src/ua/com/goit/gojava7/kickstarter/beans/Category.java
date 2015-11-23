package ua.com.goit.gojava7.kickstarter.beans;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int uniqueID;
	private String name;

	public Category(String name) {
		this.name = name;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getCategoryName() {
		return name;
	}
	
	public void setCategoryName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id : " + uniqueID + ", name : " + name;
	}
}
