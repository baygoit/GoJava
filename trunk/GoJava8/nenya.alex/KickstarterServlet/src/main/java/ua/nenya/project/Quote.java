package ua.nenya.project;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Quote {
	private String name;

	public Quote() {
	}
	
	public Quote(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
