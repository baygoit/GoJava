package com.goit.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailChecker() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean validate(final String email) {
		matcher = pattern.matcher(email);

		return matcher.matches();
	}

}
