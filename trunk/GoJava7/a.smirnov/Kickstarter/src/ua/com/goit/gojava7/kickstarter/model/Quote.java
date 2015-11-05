	package ua.com.goit.gojava7.kickstarter.model;

public class Quote {
	private String author;
	private String title;

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		String infoQuote = getTitle() + " \n" + getAuthor();
		return infoQuote;
	}
}
 