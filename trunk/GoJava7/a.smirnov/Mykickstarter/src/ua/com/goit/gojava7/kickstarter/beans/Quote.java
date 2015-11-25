package ua.com.goit.gojava7.kickstarter.beans;

public class Quote {
	private String quoteText;
	private String author;
	
	public Quote(String quoteText, String author) {
		this.quoteText = quoteText;
		this.author = author;
	}

	public void setQuoteText(String title) {
		this.quoteText = title;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "text : " + quoteText + ",\n author : " + author;
	}
}
