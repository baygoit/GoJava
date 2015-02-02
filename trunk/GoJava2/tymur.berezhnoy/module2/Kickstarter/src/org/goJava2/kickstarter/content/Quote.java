package org.goJava2.kickstarter.content;

public class Quote {
	
	private final char copyrightSymbol = 169;
	private String content;
	private String author;
	
	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public String getQuoteContent() {
		return new String("\"" + content + "\"" + " " + copyrightSymbol + " " + author);
	}
}