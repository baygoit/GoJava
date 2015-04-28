/*
 * Service class. Makes anagram
 * spaces between words are reduced to one space
 * spaces at the beginning and the end of the line are trimmed
 */

package com.sergiisavin;

public class AnagramsMaker {
	
	private static AnagramsMaker anagramsMaker = null;
	
	private AnagramsMaker(){}

	//get singleton
	public static AnagramsMaker getAnagramsMaker(){
		
		if(anagramsMaker == null){
			anagramsMaker = new AnagramsMaker();
		}
		
		return anagramsMaker; 
	}
	
	public static String makeAnagram(String inputString){
		String anagram = null;
		
		String[] words = inputString.split("\\s+");
		
		reverseWords(words);

		anagram = constructAnagram(words);
		
		return anagram;
	}

	private static String constructAnagram(String[] words) {
		String anagram = null;
		
		//in our anagram, there will be one space between words
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
		
		for(int index = 0; index < words.length; index++){
			
			words[index] = words[index].trim();
			char[] wordAsChars = words[index].toCharArray();
			
			reverseWord(wordAsChars);
			
			words[index] = new String(wordAsChars);
			
		}
		
	}

	private static void reverseWord(char[] wordAsChars) {
		
		int lastIndex = wordAsChars.length - 1;
		for(int index = 0; index < (wordAsChars.length)/2; index++){
			
			char temp = wordAsChars[index];
			wordAsChars[index] = wordAsChars[lastIndex - index];
			wordAsChars[lastIndex - index] = temp;
			
		}
	}
}
