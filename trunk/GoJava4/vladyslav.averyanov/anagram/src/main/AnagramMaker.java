package main;

import java.io.*;

public class AnagramMaker {
	
	public static final String STANDART_SEPARATOR = "[,;:.!?\\s]+";
	public static final String STANDART_USER_INPUT = "мама мыла раму";

	public static void main(String[] args) throws IOException {
		System.out.print("Enter words to inverse them: ");
		String userInput = readUserInput();
		//String userInput = STANDART_USER_INPUT;
		//System.out.println(userInput);
		System.out.print("Here's your anagram:         ");
		System.out.println(doAnagram(userInput, STANDART_SEPARATOR));
	}
	
	//TODO make exception handling 
	public static String readUserInput() throws IOException {
		InputStreamReader myInputStreamReader = new InputStreamReader(System.in);
		BufferedReader myBufferedReader = new BufferedReader(myInputStreamReader);
		String result = myBufferedReader.readLine();
		return result;
	}
	
	public static String doAnagram(String userInput, String separator) {
		String [] separateWords = makeSeparateWords(userInput, separator);
		String [] inversedWords = inverseEachWord(separateWords);
		String result = makeOneString(inversedWords);
		return result;
	}
	
	public static String[] makeSeparateWords(String inputString, String separator) {
		String [] result = inputString.trim().split(separator); //.split("[,;:.!?\\s]+");
		return result;
	}
	
	public static String[] inverseEachWord(String[] words) {
		String [] result = new String [words.length];
		int wordIndex = 0;
		for (String word : words){
			result[wordIndex] = inverseWord(word);
			wordIndex++;
		}
		return result;
	}
	
	public static String inverseWord(String word) {
		StringBuffer result = new StringBuffer();
		for (int index = word.length()-1; index>=0; index--){
			result.append(word.charAt(index));
		}
		return result.toString();
	}
	
	public static String makeOneString(String[] words) {
		StringBuffer result = new StringBuffer();
		for (String word : words){
			result.append(word).append(" ");
		}

		return result.toString();
	}
}