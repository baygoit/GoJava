package ua.com.goit.gojava7.kickstarter.beans;

public class Quote {
	
	private String text;
	private String author;

	public String getQuoteText() {
		return text;
	}
	
	public void setQuoteText(String title) {
		this.text = title;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
