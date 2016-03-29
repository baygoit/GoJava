package com.anmertrix.domain;

public class Quote {

	private String author;
	private String quoteText;

	public Quote(String author, String quoteText) {
		this.author = author;
		this.quoteText = quoteText;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public String getAuthor() {
		return author;
	}
}
