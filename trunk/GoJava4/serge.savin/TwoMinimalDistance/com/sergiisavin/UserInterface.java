/*
 * The class is responsible for user interface
 * input user data
 * input data controll
 * show hints and results
 * 
 */

package com.sergiisavin;

import java.util.Scanner;

public class UserInterface {

	private static final String EXIT_COMMAND = "exit";
	
	private static Scanner scanner = new Scanner(System.in);
	private static String inputData = null;
	private static double[] numbers = null;
	
	public static void main(String[] args){
		
		do{

			System.out.print("Input some numbers divided by space (or 'exit' to end the programm): ");
			
			//IS IT OK, OR BETTER SPECIFY WHERE THE INPUT DATA GOES LIKE: inputData = getInputData()??????? 
			getInputData();
			
			if(inputData.equals(EXIT_COMMAND)){
				System.out.println("By!");
				System.exit(0);
			}
			
			//Getting an array of elements from the input string
			String[] elements = inputData.split("\\s+");
			
			//trying to convert the array of strings into an array doubles
			try{
				numbers = getNumbers(elements);
			}catch(NumberFormatException ex){
				System.out.println("Incorrect input data...");
				System.out.println("Enter integers or doubles  (Example: 3 5 11.7 2e4 7): ");
				continue;
			}
			
			try{
				
			int distance = calculateDistance(numbers);
			
			System.out.println("The distance between two minimal elements is: " + distance);
			
			}catch(IllegalArgumentException ex){
				System.out.println(ex.getMessage());
			}
				
		}while(true);
	}

	private static int calculateDistance(double[] numbers) {
		DistanceFinder distanceFinder = DistanceFinder.getDistanceFinder();
		return distanceFinder.findDistance(numbers);
	}

	private static void getInputData() {
		inputData = scanner.nextLine();  
		inputData = trimAndToLowerCase(inputData);
	}

	private static String trimAndToLowerCase(String inputData) {
		inputData = inputData.trim();
		inputData = inputData.toLowerCase();
		return inputData;
	}

	//converting an array of strings into an array of doubles
	//if impossible cast NumberFormatException
	//return an array of doubles
	private static double[] getNumbers(String[] elements) {
		double[] numbers = new double[elements.length];
		for(int index = 0; index < elements.length; index++){
			numbers[index] = Double.parseDouble(elements[index]);
		}
		return numbers;
	}

}