package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;

public class Quote implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String author;
	private String quoteText;
	
	public Quote(String author, String quoteText) {
		this.author = author;
		this.quoteText = quoteText;
	}

	public void setQuoteText(String title) {
		this.quoteText = title;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return getQuoteText();
	}
}
