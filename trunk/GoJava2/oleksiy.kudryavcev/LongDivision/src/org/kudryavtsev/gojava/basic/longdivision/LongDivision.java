/**
 *  GoJava2
 *  Project #4 "Long Division"
 *  Date: 2014-12-28
 */

package org.kudryavtsev.gojava.basic.longdivision;

import java.util.Scanner;

/**
 * @author Omicron
 * @version 0.09
 */

public class LongDivision {

    public static void main(String[] args) {
	final int DEPTH = 6;
	String inputString = "";
	System.out.println("Input numerator/denominator (e.g. 12/42):");
	Scanner in = new Scanner(System.in);
	inputString = in.nextLine();
	in.close();

	analize(DEPTH, inputString);
    }

    private static void analize(final int DEPTH, String stringToAnalize) {
	int positionOfDevider = stringToAnalize.indexOf("/");
	int numerator = Integer.parseInt(stringToAnalize.substring(0, positionOfDevider));
	int denominator = Integer.parseInt(stringToAnalize.substring(positionOfDevider + 1, stringToAnalize.length()));

	printDivision(DEPTH, numerator, denominator);
    }

    private static void printDivision(final int DEPTH, int numerator, int denominator) {
	double result = (double) numerator / denominator;
	System.out.print(" " + numerator + " |" + denominator + "\n ");

	final int DIGIT = 10;	
	int tempNumber;
	int tempDigit;
	String adjust = "";
	String suffix = "|" + result;
	tempNumber = numerator * DIGIT;

	for (int i = 0; i < DEPTH; i++) {
	    tempDigit = (int) (result * DIGIT * Math.pow(DIGIT, i)) % DIGIT;
	    System.out.println(adjust + "-" + tempDigit * denominator + suffix + "\n" + adjust + " ---");
	    tempNumber = (tempNumber - tempDigit * denominator) * DIGIT;
	    adjust += " ";
	    suffix = "";
	    System.out.println(" " + adjust + tempNumber);
	}
    }
}
