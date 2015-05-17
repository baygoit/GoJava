package model;

public class Quote {
	
	private String content;
	private String author;
	
	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}
	
	public String getQuoteWithAuthor() {
		return ("\""+getContent()+"\", "+getAuthor());
	}

	private String getContent() {
		return content;
	}

	private String getAuthor() {
		return author;
	}

}
