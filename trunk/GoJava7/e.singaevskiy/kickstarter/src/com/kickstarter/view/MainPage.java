package com.kickstarter.view;

import com.kickstarter.beans.Quote;

public class MainPage {
	
	public void updateQuote(Quote quote) {
		System.out.println(quote.getAuthor() + " : \"" + 
				quote.getText() + "\"");
	}
	
}
