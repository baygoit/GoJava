package goit.nz.kickstarter.memory;

public class Quote {

	private String text;
	private String author;

	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}

	public Quote(String text) {
		this.text = text;
		this.author = "Unknown";
	}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}
}
