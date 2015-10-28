/**
 *  GoJava2
 *  Project #3 "Anagram"
 *  Date: 2014-12-28
 */
package org.kudryavtsev.gojava.basic.anagram;

import java.util.Scanner;

/**
 * @author Omicron
 * @version 0.16
 */
public class Anagram {

    public static void main(String[] args) {
	String stringToAnalize = "";
	System.out.println("Enter the string:");
	Scanner in = new Scanner(System.in);
	stringToAnalize = in.nextLine();
	in.close();
	printReversedLine(stringToAnalize);
    }

    static void printReversedLine(String stringToReverse) {
	String word = "";
	for (int i = 0; i < stringToReverse.length(); i++) {
	    word = stringToReverse.substring(i, i + 1) + word;
	    if (stringToReverse.substring(i, i + 1).equals(" ")) {
		System.out.print(word.substring(1, word.length()) + " ");
		word = "";
	    } else {
		if (i == stringToReverse.length() - 1)
		    System.out.print(word);
	    }
	}
    }
}
