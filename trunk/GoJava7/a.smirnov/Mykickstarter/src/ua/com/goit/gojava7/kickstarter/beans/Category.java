package ua.com.goit.gojava7.kickstarter.beans;

import java.io.Serializable;

public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int uniqueID;

	public Category(String name) {
		this.name = name;
	}

	public String getCategoryName() {
		return name;
	}
	
	public void setCategoryName(String name) {
		this.name = name;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
}
