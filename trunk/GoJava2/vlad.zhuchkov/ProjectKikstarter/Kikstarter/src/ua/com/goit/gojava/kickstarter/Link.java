package ua.com.goit.gojava.kickstarter;


import java.io.Serializable;

public class Link implements Serializable {
	private String url;

	public String getUrl() {
		return url;
	}

	public Link() {
		url = "www.google.com";
	}

}
