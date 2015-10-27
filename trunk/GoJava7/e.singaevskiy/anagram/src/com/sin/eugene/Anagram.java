package com.sin.eugene;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
	
	private static final String PATTERN = "[A-zÀ-ÿ¨¸]+";
	
	public static String reverse(String text) {

		StringBuilder rezult = new StringBuilder(text);
		Matcher matcher = Pattern.compile(PATTERN).matcher(text);
		
		while (matcher.find()) {
			rezult.replace(
					matcher.start(), 
					matcher.end(), 
					new StringBuilder(matcher.group()).reverse().toString());
			System.out.println(matcher.group());
		}

		return rezult.toString();
	}
	
}
