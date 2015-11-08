package com.goit.anagram;

import java.util.StringTokenizer;

public class Anagram {
	
	private final String delim = " ,.!?@#$%^&*()-_=+<>/\';:[]{}|~`\"";
	
	public String getReversedSentence(String sentence) {
		String result = "";
		
		if(sentence == null) {
			return result;
		} else {	
		StringTokenizer tokenizer = new StringTokenizer(sentence, delim, true );
		while(tokenizer.hasMoreTokens()) {
			result += new StringBuilder(tokenizer.nextToken()).reverse();
		}
		return result;
		}
	}
}
	