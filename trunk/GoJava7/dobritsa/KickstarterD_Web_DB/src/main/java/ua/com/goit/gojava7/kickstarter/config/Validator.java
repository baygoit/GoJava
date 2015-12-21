package ua.com.goit.gojava7.kickstarter.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean validateAmountOfPledge(String amount) {
		Pattern p = Pattern.compile("^[0-9]{1,10}$");
		Matcher m = p.matcher(amount);
		return m.matches();
	}

	public static boolean validateCard(String card) {
		Pattern p = Pattern.compile("^[0-9]{16,16}$");
		Matcher m = p.matcher(card);
		return m.matches();
	}

	public static boolean validateName(String name) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-z]{2,20}$");
		Matcher m = p.matcher(name);
		return m.matches();
	}
}
