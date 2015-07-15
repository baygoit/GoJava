package goit.nz.kickstartermvc.dao;

public class Quote {
	
	private String text;
	private String author;

	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}

	public Quote(String quote) {
		this.text = quote;
		this.author = "Unknown";
	}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}
}
