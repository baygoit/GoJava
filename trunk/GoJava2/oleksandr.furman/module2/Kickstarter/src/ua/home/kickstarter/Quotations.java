package ua.home.kickstarter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Quotations {
	private JSONObject jsonObject;
    int jsonObjectSize;
    
	public Quotations() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("d:\\ss33.json"));
			jsonObject = (JSONObject) obj;
			jsonObjectSize = jsonObject.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String nextQuote(int index) {
		return (String) jsonObject.get("" + index);
	}
}
