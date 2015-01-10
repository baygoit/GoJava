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

import java.util.Scanner;

/**
 * @author Omicron
 * @version 0.21
 */
public class Distance {
    public static void main(String[] args) {

	/*
	 * least - the most minimal value in the given row of int numbers min -
	 * the second minimal value distance - distance between them
	 * positionLeast - position of the least value positionMin - position of
	 * the min value
	 */

	int positionLeast = 0;
	int positionCurrent = 1;

	System.out.println("Enter numbers, as a last number type any letter:");
	Scanner in = new Scanner(System.in);

	// Assign least and min for first two given numbers

	if (in.hasNextInt()) {
	    define2Minimums(positionLeast, positionCurrent, in);
	}
    }

    private static void define2Minimums(int positionLeast, int positionCurrent,
	    Scanner in) {
	int temp;
	int min;
	int least;
	int positionMin;
	least = in.nextInt();
	if (in.hasNextInt()) {
	    temp = in.nextInt();
	    if (temp <= least) {
		min = least;
		least = temp;
		positionMin = 0;
		positionLeast = 1;

	    } else {
		min = temp;
		positionMin = 1;
	    }

	    /*
	     * Check other numbers till the and If current value less then least
	     * - shift least to min and current to least If current value
	     * between the least and min - shifting just min value
	     */

	    while (in.hasNextInt()) {
		temp = in.nextInt();
		positionCurrent++;
		if (temp <= least) {
		    min = least;
		    least = temp;
		    positionMin = positionLeast;
		    positionLeast = positionCurrent;
		} else if (temp <= min) {
		    min = temp;
		    positionMin = positionCurrent;
		}
	    }

	    in.close();
	    System.out.println("The smallest numbers " + least + " and " + min
		    + ". Distance between them - "
		    + Math.abs(positionMin - positionLeast));

	} else {
	    System.out.println("Unable to find. You entered just one number.");
	}
    }
}
