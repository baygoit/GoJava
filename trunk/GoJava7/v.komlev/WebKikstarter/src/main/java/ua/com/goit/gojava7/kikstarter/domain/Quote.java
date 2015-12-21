package ua.com.goit.gojava7.kikstarter.domain;


public class Quote {

	private String content;
	private String author;
	
	public Quote(){
	}

	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public void setContent(String quoteContent) {
		this.content = quoteContent;
	}

	public void setAuthor(String quoteAuthor) {
		this.author = quoteAuthor;
	}

	public String toString() {
		return "\nContent: " + content + "\nAuthor: " + author;
	}

}
