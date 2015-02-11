package ua.home.kickstarter.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import ua.home.kickstarter.content.Quote;

public class QuotationsStorage {
	private List<Quote> quotationsList;

	public QuotationsStorage() {
		jsonQuotationsToList();
	}

	private void jsonQuotationsToList() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:\\Quotations.json"));
			JsonParser parser = new JsonParser();
			JsonArray jArrayQuotations = parser.parse(br).getAsJsonArray();
			Gson gson = new Gson();
			quotationsList = new ArrayList<Quote>();
			for (JsonElement obj : jArrayQuotations) {
				Quote quote = gson.fromJson(obj, Quote.class);
				quotationsList.add(quote);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Quote getRandomQuote() {
		int i = new Random().nextInt(quotationsList.size());
		return quotationsList.get(i);
	}
}
