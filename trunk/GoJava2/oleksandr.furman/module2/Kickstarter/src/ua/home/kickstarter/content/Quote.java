package ua.home.kickstarter.content;

import org.json.simple.JSONObject;

public class Quote {
	private String quote;
	
	public Quote(JSONObject jsonObject) {
		this.quote = "" + jsonObject.get("quote");
	}

	public String getQuote() {
		return quote;
	}
}
