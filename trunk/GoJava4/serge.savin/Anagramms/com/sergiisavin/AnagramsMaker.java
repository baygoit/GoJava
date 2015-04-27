/*
 * Service class. Makes anagram
 * spaces between words are reduced to one space
 * spaces at the beginning and the end of the line are trimmed
 */

package com.sergiisavin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramsMaker {

	public static String makeAnagram(String inputString){
		String anagram = null;
		
		String[] words = inputString.split("\\s+");
		
		reverseWords(words);

		anagram = constructAnagram(words);
		
		return anagram;
	}

	private static String constructAnagram(String[] words) {
		String anagram = null;
		
		//in our anagram will be one space between words
		StringBuilder sb = new StringBuilder();
		for(String s : words){
			sb.append(s);
			sb.append(" ");
		}
		//there will be no spaces at the beginning and the end
		anagram = sb.toString().trim();
		return anagram;
	}

	//reverse word as char array 
	private static void reverseWords(String[] words) {
		
		for(int i = 0; i < words.length; i++){
			
			words[i] = words[i].trim();
			char[] wordInChars = words[i].toCharArray();
			
			int lastIndex = wordInChars.length - 1;
			for(int j = 0; j < (wordInChars.length)/2; j++){
				
				char temp = wordInChars[j];
				wordInChars[j] = wordInChars[lastIndex - j];
				wordInChars[lastIndex - j] = temp;
				
			}
			
			words[i] = new String(wordInChars);
			
		}
		
	}
}
