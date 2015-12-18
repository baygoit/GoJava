package ua.com.goit.gojava7.kickstarter.domain;

public class Quote {

	private String text;
	private String author;

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Quote [text=" + text + ", author=" + author + "]";
	}
}
