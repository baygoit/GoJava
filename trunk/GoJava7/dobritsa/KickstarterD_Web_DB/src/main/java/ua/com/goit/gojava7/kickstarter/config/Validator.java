package ua.com.goit.gojava7.kickstarter.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Validator {
	
	private static final Logger log = LoggerFactory.getLogger(Validator.class);	 

	public boolean validateAmountOfPledge(String amount) {
		log.info("validateAmountOfPledge({})...", amount);
		Pattern p = Pattern.compile("^[0-9]{1,10}$");
		Matcher m = p.matcher(amount);
		return m.matches();
	}
	
	public boolean validatePayment(String name, String card) {
		log.info("validatePayment({}, {})...", name, card);
		if (validateName(name) & validateCard(card)) return true;
		else return false;
	}

	public boolean validateName(String name) {
		log.info("validateName({})...", name);
		Pattern p = Pattern.compile("^[a-zA-Z][a-z]{2,20}$");
		Matcher m = p.matcher(name);
		return m.matches();
	}
	
	public boolean validateCard(String card) {
		log.info("validateCard({})...", card);
		Pattern p = Pattern.compile("^[0-9]{16,16}$");
		Matcher m = p.matcher(card);
		return m.matches();
	}
}
