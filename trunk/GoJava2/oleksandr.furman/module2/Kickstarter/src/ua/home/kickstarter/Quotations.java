package ua.home.kickstarter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Quotations {
	private JSONObject jsonObject;
	public Quotations() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("d:\\Quotations.json"));
			jsonObject = (JSONObject) jsonArray.get(new Random().nextInt(jsonArray.size()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String randomQuote() {
		return (String) jsonObject.get("quote");
	}
	
}
