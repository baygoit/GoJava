package ua.com.goit.gojava.kickstarter.data;

import java.io.Serializable;

public class Link implements Serializable {
	private String url;

	public String getUrl() {
		return url;
	}

	public Link(String name) {
		url = name;
	}

}
