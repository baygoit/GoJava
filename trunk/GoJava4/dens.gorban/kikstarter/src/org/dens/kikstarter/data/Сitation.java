package org.dens.kikstarter.data;

public class Сitation {
	
	private String phrase;
	private String author;
	
	public Сitation(String phrase, String author) {
		super();
		this.phrase = phrase;
		this.author = author;
	}

	public String getPhrase() {
		return phrase;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return  phrase + " '" + author + "'";
	}
	
	
	
}
