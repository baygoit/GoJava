package ua.com.goit.gojava7.kickstarter.model;

public class Quote {
	private String text;
	private String author;
	private int idQuote;
	
	public Quote() {}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}
	
	public int getIdQuote() {
		return idQuote;
	}

	public void setIdQuote(int idQuote) {
		this.idQuote = idQuote;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setText(String text) {
		this.text = text;
	}

}
