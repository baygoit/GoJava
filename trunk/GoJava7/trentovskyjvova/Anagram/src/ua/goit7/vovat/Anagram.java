package ua.goit7.vovat;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {

	public static void main(String[] args) {
		
		String anagramString = "";

		if (args.length != 0) {
			anagramString = readFromArgs(args);
		} else {
			anagramString = scanUserInput();
		}

		anagramString = reverseWords(anagramString);

		System.out.println(anagramString);
	}

	private static String readFromArgs(String[] args) {

		StringBuilder sb = new StringBuilder();
		for (String string : args) {
			sb.append(string);
			sb.append(" ");
		}
		return sb.toString();
	}

	private static String reverseWords(String anagramString) {
	
		Pattern p = Pattern.compile("([\\p{L}]*)");
		Matcher matcher = p.matcher(anagramString);

		while (matcher.find()) {
			String reverse = new StringBuilder(matcher.group(1)).reverse().toString();
			anagramString = anagramString.replaceAll(matcher.group(1), reverse);
		}
		return anagramString;
	}

	private static String scanUserInput() {
		
		String anagramString = "";
		System.out.println("Enter a sequence of characters");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			anagramString = s.nextLine();
		}
		s.close();
		
		return anagramString;
	}

}
