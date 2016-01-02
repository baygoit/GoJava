package ua.com.goit.gojava7.kickstarter.domain;

public class Quote {
	
	private int id;
	private String text;
	private String author;
	
	public Quote() {

	}
	
	public Quote(String text, String author) {
		setText(text);
		setAuthor(author);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
