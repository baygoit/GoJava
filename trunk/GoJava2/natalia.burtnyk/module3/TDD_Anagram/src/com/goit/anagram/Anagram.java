package com.goit.anagram;

import java.util.StringTokenizer;

public class Anagram {
	
	public String getReversedSentence(String sentence) {
		String result = "";
		
		StringTokenizer tokenizer = new StringTokenizer(sentence, " ,.!?@#$%^&*()-_=+<>/\';:[]{}|~`\"", true);
		while(tokenizer.hasMoreTokens()) {
			result += new StringBuilder(tokenizer.nextToken()).reverse();
		}
		return result;
	}	
}