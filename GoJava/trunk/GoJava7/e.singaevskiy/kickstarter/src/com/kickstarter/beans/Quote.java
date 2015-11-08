package com.kickstarter.beans;

public class Quote {
	private String author;
	private String text;

	public Quote() {
		super();
	}
	
	public Quote(String author, String text) {
		super();
		this.author = author;
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
