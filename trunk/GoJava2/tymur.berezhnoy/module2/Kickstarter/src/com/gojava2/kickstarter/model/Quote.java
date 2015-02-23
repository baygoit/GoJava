package com.gojava2.kickstarter.model;

public class Quote {
	
	private String author;
	private String content;
	
	private final char copyrightSymbol = 169;
	
	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public char getCopyrightSymbol() {
		return copyrightSymbol;
	}
}