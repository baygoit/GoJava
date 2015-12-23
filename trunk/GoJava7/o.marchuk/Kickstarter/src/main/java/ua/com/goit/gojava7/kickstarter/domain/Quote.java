package ua.com.goit.gojava7.kickstarter.domain;

public class Quote {

	private Long id;
	private String text;
	private String author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Quote [text=" + text + ", author=" + author + "]";
	}
}
