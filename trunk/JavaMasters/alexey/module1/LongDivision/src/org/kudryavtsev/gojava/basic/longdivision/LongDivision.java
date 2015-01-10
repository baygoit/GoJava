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

		String stringToAnalize = "";
		Scanner in = new Scanner(System.in);
		stringToAnalize = in.nextLine();
		final int DEPTH = 6;

		int positionOfDevider = stringToAnalize.indexOf("/");
		// System.out.println(stringToAnalize + " " + positionOfDevider);

		int numerator = Integer.parseInt(stringToAnalize.substring(0,
				positionOfDevider));
		int denominator = Integer.parseInt(stringToAnalize.substring(
				positionOfDevider + 1, stringToAnalize.length()));
		//double 

		System.out.println(numerator + " |" + denominator + "\n "
				+ (double) numerator / denominator);

		in.close();
		
		for(int i = 0; i <= DEPTH; i++) {
			
		}
	}

}
