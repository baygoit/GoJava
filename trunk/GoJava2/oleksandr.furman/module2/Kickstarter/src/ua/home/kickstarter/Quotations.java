package ua.home.kickstarter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Quotations {
	String quote = "";
    public String nextQuote() {
    	JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("d:\\ss33.json"));
			JSONObject jsonObject = (JSONObject) obj;
			quote = (String) jsonObject.get("" + new Random().nextInt(jsonObject.size()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
  return quote;
 }
}
