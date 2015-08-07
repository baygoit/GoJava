package belskii.artem.kickstarter.mvc.controller;

import belskii.artem.kickstarter.mvc.model.QuoteModel;

public class QuoteController {
	QuoteModel model;
	public QuoteController(QuoteModel model){
		this.model=model;
	}
	public String getRandomQuote(){
		return model.getRandomQuote();
	}
	
	public void addquote(String quote){
		model.addQuote(quote);
	}

}
