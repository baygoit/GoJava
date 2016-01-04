package com.kickstarter.model;

public class Quote {

	private int id;
	private String quote;
	private String author;

	public Quote() {
	}

	public Quote(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
