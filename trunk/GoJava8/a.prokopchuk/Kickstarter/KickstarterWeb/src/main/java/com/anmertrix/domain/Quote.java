package com.anmertrix.domain;

public class Quote {

	private String author;
	private String quoteText;
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public String getAuthor() {
		return author;
	}
}
