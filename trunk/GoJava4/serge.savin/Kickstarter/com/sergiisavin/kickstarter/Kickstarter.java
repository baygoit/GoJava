package com.sergiisavin.kickstarter;

public class Kickstarter {
	
	private Quotes quotes;
	private Categories categories;
	

	public Kickstarter(){
	
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;	
	}

	public String getRandomQuote() {
		return quotes.getRandomQuote();
	}
	
	public String[] getCategories(){
		String[] result = new String[categories.getSize()];
		for(int index = 0; index < categories.getSize(); index++){
			result[index] = categories.get(index).toString();
		}
		return result;
	}
	
}
