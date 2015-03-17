/**
 * Created by Sergey Poznyak on 08.01.2015
 * 
 * This program implements the long division
 * with graphic output into the console
 */
package ua.com.goit.gojava.poznyak;

import java.util.*;

/**
 * The main class.
 * 
 * @version 3.0 17 Mar 2015
 * @author Sergey Poznyak
 */
public class LongDivision {

	/**
	 * Gets user's input and prints visualization.
	 * 
	 * @param args is not used
	 * @throws LongDivisionException 
	 */
	public static void main(String[] args) throws LongDivisionException {
		Scanner inputScan = new Scanner(System.in);
		int dividend;
		int divisor;
		System.out.println("Input the dividend:");
		dividend = inputScan.nextInt();
		System.out.println("Input the divisor:");
		divisor = inputScan.nextInt();
		inputScan.close();
		Division divClass = new Division(dividend, divisor);
		System.out.println("Division result: " + divClass.divide());
		System.out.println("Visualization:\n" + divClass.visualize());
	}
	
}
