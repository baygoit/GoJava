package ua.com.goit.gojava7.kickstarter.beans;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

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
}
