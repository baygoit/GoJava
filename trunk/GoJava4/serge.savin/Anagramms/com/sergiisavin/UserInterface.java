/*
 * User Interface. Prompts input data 
 * Provides a way to finish the program
 * displays the result
 * 
 * 
 */

package com.sergiisavin;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String inputData = null;
		
		do{
			
			System.out.print("Do you want to continue? (y/n): ");
			
			inputData = scanner.nextLine();
			
			inputData = inputData.trim();
			inputData = inputData.toLowerCase();
			
			switch(inputData){
			
			case "n":
				System.out.println("Goodby!");
				scanner.close();
				System.exit(0);
				break;
			case "y":
				System.out.print("Enter some text: ");
				inputData = scanner.nextLine();
				inputData = inputData.trim();
				System.out.println("The anagram: " + AnagramsMaker.makeAnagram(inputData));
				break;
			}
							
			
		}while(true);
	}
}
