/**
 *  GoJava2
 *  Project #4 "Long Division"
 *  Date: 2014-12-28
 */

package org.kudryavtsev.gojava.basic.longdivision;

import java.util.Scanner;

/**
 * @author Omicron
 * @version 0.05
 */

public class LongDivision {

    public static void main(String[] args) {
	final int DEPTH = 1;
	String inputString = "12/42";
	// Scanner in = new Scanner(System.in);
	// inputString = in.nextLine();
	// in.close();

	analize(DEPTH, inputString);
    }

    private static void analize(final int DEPTH, String stringToAnalize) {
	int positionOfDevider = stringToAnalize.indexOf("/");
	int numerator = Integer.parseInt(stringToAnalize.substring(0,
		positionOfDevider));
	int denominator = Integer.parseInt(stringToAnalize.substring(
		positionOfDevider + 1, stringToAnalize.length()));

	printDivision(DEPTH, numerator, denominator);
    }

    private static void printDivision(final int DEPTH, int numerator,
	    int denominator) {
	double result = (double) numerator / denominator;

	System.out.println(" " + numerator + " |" + denominator);

	for (int i = 0; i < DEPTH; i++) {
	    int t;
	    String adjust = "";
	    
	    int tempDigit = (int) (result * 10) % 10;
	    System.out.println("  " + adjust + tempDigit * denominator + "|" + result + "\n" + " ---");
	    t = (numerator * 10 - tempDigit * denominator) * 10;
	    adjust +=" ";	    
	    System.out.println(" " + adjust + t);


	    int tempDigit2 = (int) (result * 100) % 100 - tempDigit * 10;
	    System.out.println(adjust + "-" + tempDigit2 * denominator + "\n" + " " + " ---");
	    t = (t - tempDigit2 * denominator)* 10;
	    adjust +=" ";	    
	    System.out.println(" " + adjust + t );

	    
	    int tempDigit3 = (int) (result * 1000) % 1000 - tempDigit * 100 - tempDigit2 * 10;
	    System.out.println(adjust + "-" + tempDigit3 * denominator + "\n" + " " + " ---");
	    t = (t  - tempDigit3 * denominator)* 10;
	    adjust +=" ";	    
	    System.out.println(" "+ adjust + t );

	    
	    
	}
    }

}
