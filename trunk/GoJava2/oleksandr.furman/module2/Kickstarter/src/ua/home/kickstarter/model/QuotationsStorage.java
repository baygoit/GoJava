package ua.home.kickstarter.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ua.home.kickstarter.content.Quote;

public class QuotationsStorage {
	private List<Quote> quotationsList;

	public QuotationsStorage() {
		jsonQuotationsToList();
	}

	private void jsonQuotationsToList() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonQuotationsArray = (JSONArray) parser.parse(new FileReader("d:\\Quotations.json"));
			quotationsList = new ArrayList<Quote>();
			for (Object jsonQuotationsObject : jsonQuotationsArray) {
				JSONObject jsonQuotations = (JSONObject) jsonQuotationsObject;
				quotationsList.add(new Quote("" + jsonQuotations.get("quote")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Quote getRandomQuote() {
		int i = new Random().nextInt(quotationsList.size());
		return quotationsList.get(i);
	}

}
