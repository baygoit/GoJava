package com.kickstarter.model;

public class Quote {

	private int id;
	private String quoteText;
	private String author;

	public Quote() {
	}

	public Quote(String quoteText, String author) {
		this.quoteText = quoteText;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
