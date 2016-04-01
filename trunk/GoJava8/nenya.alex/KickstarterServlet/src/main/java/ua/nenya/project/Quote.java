package ua.nenya.project;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Quote {
	private String name;

	public Quote() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
