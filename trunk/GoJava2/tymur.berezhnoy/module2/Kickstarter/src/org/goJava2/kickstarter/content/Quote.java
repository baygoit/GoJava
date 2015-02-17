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
		StringBuilder builder = new StringBuilder();
		builder.append("\"").append(content).append("\"")
			.append(copyrightSymbol).append(" ").append(author);
		return builder.toString(); 
	}
}