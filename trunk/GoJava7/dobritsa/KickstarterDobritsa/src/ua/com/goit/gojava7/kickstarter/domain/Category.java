package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.storage.Storage;

public class Category extends Storage<Project> {

	private String name;	
	
	public Category() {		
	}
	
	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}