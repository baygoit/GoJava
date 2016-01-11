package ua.com.goit.gojava7.kickstarter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Validator {
	
	private static final Logger log = LoggerFactory.getLogger(Validator.class);	 

	public boolean validateAmountOfPledge(String amount) {
		Pattern p = Pattern.compile("^[1-9]{1,10}$");
		Matcher m = p.matcher(amount);
		return m.matches();
	}
	
	public boolean validatePayer(String name, String card) {
		return validateName(name) & validateCard(card);
	}

	public boolean validateName(String name) {
		Pattern p = Pattern.compile("^[\\p{L} .'-]+$");
		Matcher m = p.matcher(name);
		return m.matches();
	}
	
	public boolean validateCard(String card) {
		Pattern p = Pattern.compile("^[0-9]{16}$");
		Matcher m = p.matcher(card);
		return m.matches();
	}


	public boolean validateQuestion(String question) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]{2,500}$");
		Matcher m = p.matcher(question);
		return m.matches();
	}
}
