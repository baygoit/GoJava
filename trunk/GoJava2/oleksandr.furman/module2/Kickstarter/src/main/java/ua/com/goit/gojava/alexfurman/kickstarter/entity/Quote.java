package ua.com.goit.gojava.alexfurman.kickstarter.entity;

public class Quote {

	private Integer id;

	private String quote;

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getQuote() {
		return quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
