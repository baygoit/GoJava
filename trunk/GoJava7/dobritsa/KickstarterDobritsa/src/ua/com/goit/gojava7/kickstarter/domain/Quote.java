package ua.com.goit.gojava7.kickstarter.domain;

public class Quote {

	private String text;
	private String author;
	
	public Quote() {
		
	}

	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
