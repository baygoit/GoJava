package ua.com.goit.gojava7.kickstarter.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class Category implements Comparable<Category>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Category that) {
		return this.getName().compareTo(that.getName());
	}
}
