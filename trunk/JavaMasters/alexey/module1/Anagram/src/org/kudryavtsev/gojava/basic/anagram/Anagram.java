/**
 *  GoJava2
 *  Project #3 "Anagram"
 *  Date: 2014-12-28
 */
package org.kudryavtsev.gojava.basic.anagram;

import java.util.Scanner;

/**
 * @author Omicron
 * @version 0.12
 */
public class Anagram {

    public static void main(String[] args) {

	String stringToAnalize = "";
	System.out.println("Enter the string:");

	Scanner in = new Scanner(System.in);
	stringToAnalize = in.nextLine();
	in.close();
	System.out.println(reversedLine(stringToAnalize));
    }

    static String reversedLine(String stringToReverse) {
	stringToReverse = stringToReverse.concat(" ");
	String output, word;
	output = "";
	word = "";
	int stringToReverseLength = stringToReverse.length();

	for (int i = 1; i <= stringToReverseLength; i++) {
	    String letter;

	    letter = stringToReverse.substring(i - 1, i);

	    if (letter.contains(" ")) {
		output = output.concat(reverseWord(word) + " ");
		word = "";
	    } else {
		word = word.concat(letter);
	    }
	}
	return output.substring(0, stringToReverseLength - 1);
    }

    static String reverseWord(String stringToReverse) {
	String resultString = "";
	for (int i = stringToReverse.length(); i > 0; i--) {
	    resultString = resultString.concat(stringToReverse.substring(i - 1,
		    i));
	}
	return resultString;
    }

}
