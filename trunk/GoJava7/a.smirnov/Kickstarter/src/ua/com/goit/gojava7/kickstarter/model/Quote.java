package ua.com.goit.gojava7.kickstarter.model;

public class Quote {

	private String author;
	private String quoteText;

	public void setQuoteText(String title) {
		this.quoteText = title;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

<<<<<<< HEAD
	public String getAuthor() {
		return author;
=======
	@Override
	public String toString() {
		// OLEG no StringBuilder? Why? :)
		String infoQuote = getTitle() + " \n" + getAuthor();
		return infoQuote;
>>>>>>> ab663b305363e409959091aee5fef442b1a5cbf8
	}
}
