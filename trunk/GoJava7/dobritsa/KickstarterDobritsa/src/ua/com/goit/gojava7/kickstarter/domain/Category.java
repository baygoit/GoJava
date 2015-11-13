package ua.com.goit.gojava7.kickstarter.domain;

import ua.com.goit.gojava7.kickstarter.storage.Storage;

public class Category extends Storage<Project> {

	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}