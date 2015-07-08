package goit.nz.kickstarter.dao;



public class Quote {
	private String text;
	private String author;
	private QuoteList list;
	
	public Quote(String text, String author, QuoteList list) {
		this.text = text;
		this.author = author;
		this.list = list;
		this.list.add(this);
	}
	
	public Quote(String quote, QuoteList list) {
		this.text = quote;
		this.author = "Unknown";
		this.list = list;
		this.list.add(this);
	}
	
	public String getText() {
		return text;
	}
	
	public String getAuthor() {
		return author;
	}
	
}
