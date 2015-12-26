package ua.com.goit.gojava7.kickstarter.models;

public class Quote {

	private Long quoteId;
	private String text;
	private String author;		

	public Long getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "quoteId: " + quoteId + "; quote: " + text + "; author: " + author;
	}

	public boolean isEmpty() {
		return text == null;
	}
}
