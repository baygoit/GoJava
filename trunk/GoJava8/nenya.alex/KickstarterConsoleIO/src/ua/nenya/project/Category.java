package ua.nenya.project;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Category implements GetingNameInterface {
	private String name;
	
	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
