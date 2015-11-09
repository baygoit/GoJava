package ua.com.goit.gojava7.kickstarter.domain;

public class Quote {

	private String text;
	private String author;

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}

	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}
}
