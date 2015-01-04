/**
 *  GoJava2
 *  Project #3 "Anagram"
 *  Date: 2014-12-28
 */
package org.kudryavtsev.gojava.basic.anagram;

import java.util.Scanner;

/**
 * @author Omicron
 * @version 0.09
 */
public class Main {

	public static void main(String[] args) {

		String stringToAnalize = "";
		System.out.println("Enter the string:");

		Scanner in = new Scanner(System.in);
		if (in.hasNextLine()) {
			stringToAnalize = in.nextLine().concat(" ");
		}
		in.close();

		String letter, word;		
		word = "";
		
		for (int i = 0; i < stringToAnalize.length(); i++) {
			letter = stringToAnalize.substring(i, i + 1);
			
			if (letter.contains(" ")) {
				System.out.print(reverse(word) + " ");
				word = "";
			} 
			else {
				word = word.concat(letter);
			}
		}
	}

	static String reverse(String stringToReverse) {
		String resultString = "";

		for (int i = stringToReverse.length(); i > 0; i--) {
			resultString = resultString.concat(stringToReverse.substring(i - 1,	i));
		}
		return resultString;
	}

}
