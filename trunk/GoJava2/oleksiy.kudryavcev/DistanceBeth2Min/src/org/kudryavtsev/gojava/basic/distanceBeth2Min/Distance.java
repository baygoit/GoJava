/**
 *  GoJava2
 *  Project #2 "Distance between 2 minimal values"
 *  Date: 2014-12-28
 *  To stop inserting values just press any letter
 *  
 *  Code duplication present!!!
 *  I'm trying to refactor it.
 */

package org.kudryavtsev.gojava.basic.distanceBeth2Min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Omicron
 * @version 0.25
 */
public class Distance {

    public static void main(String[] args) throws IOException {
	System.out.print("Enter numbers: ");
	BufferedReader inputString = new BufferedReader(new InputStreamReader(
		System.in));
	String[] numbers = inputString.readLine().split(" ");

	define2Minimums(numbers);
    }

    private static void define2Minimums(String[] numbers) {
	int least = Integer.MAX_VALUE;
	int min = Integer.MAX_VALUE;
	int positionMin = 1;
	int positionLeast = 0;

	if (numbers.length > 1) {
	    for (int i = 1; i < numbers.length; i++) {
		int currentValue = Integer.parseInt(numbers[i]);
		if (currentValue <= least) {
		    min = least;
		    least = currentValue;
		    positionMin = positionLeast;
		    positionLeast = i;
		} else if (currentValue <= min) {
		    min = currentValue;
		    positionMin = i;
		}
	    }
	    System.out.println("The smallest numbers " + least + " and " + min
		    + ". Distance between them - "
		    + Math.abs(positionMin - positionLeast));
	} else
	    System.out.println("Not enough numbers.");
    }
}
