package ua.com.gojava4.kickstarter.entities;

public class Quote {

	private String content;
	private String author;

	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public String getQuoteString() {
		return ("\"" + content + "\" " + author);
	}

}