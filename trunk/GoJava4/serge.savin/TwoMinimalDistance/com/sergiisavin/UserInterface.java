/*
 * The class is responsible for user interface
 * input user data
 * input data controll
 * show hints and results
 *  
 * 
 * 
 */

package com.sergiisavin;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		String inputData = null;
		double[] numbers = null;
		
		do{
			
			System.out.print("Input some numbers divided by one space (or 'exit' to end the programm): ");
			inputData = scanner.nextLine();
			  
			
			//trimming spaces on both ends and unifying register
			inputData = inputData.trim();
			inputData = inputData.toLowerCase();
			
			//if the user entered exit - so be it 
			if(inputData.equals("exit")){
				System.out.println("By!");
				System.exit(0);
			}
			
			//Getting an array of elements from the input string
			String[] elements = inputData.split(" ");
			
			//trying to convert the array of strings into an array dubles
			try{
				numbers = getNumbers(elements);
			}catch(NumberFormatException ex){
				System.out.println("Incorrect input data...");
				System.out.println("Enter integers or doubles  (Example: 3 5 11.7 2e4 7): ");
				continue;
			}
			
			//Calculating the result
			System.out.println("The distance between two minimal elements is: " + DistanceFinder.findDistance(numbers));
			
		//until user enters exit	
		}while(true);
	}

	//converting an array of strings into an array of doubles
	//if impossible cast NumberFormatException
	//return an array of doubles
	private static double[] getNumbers(String[] elements) {
		double[] numbers = new double[elements.length];
		for(int i = 0; i < elements.length; i++){
			numbers[i] = Double.parseDouble(elements[i]);
		}
		return numbers;
	}

}