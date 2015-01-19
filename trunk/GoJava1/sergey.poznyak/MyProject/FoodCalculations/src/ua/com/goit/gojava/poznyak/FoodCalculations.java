/**
 * Created by Sergey Poznyak on 15.01.2015
 * 
 * This program provides with the food calculations for hiking
 */
package ua.com.goit.gojava.poznyak;

import java.util.Scanner;

/**
 * The main class
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public class FoodCalculations {

	/**
	 * Prints the list of dishes into the console.
	 * Then prints the list of required ingredients
	 * for the chosen dish
	 * (list is present for dish #2)
	 * @param args
	 */
	public static void main(String[] args) {
		ListService service = new ListServiceImplementation();
		System.out.println("Menu:");
		for (Dish value : service.getDishes()) {
			System.out.println(value);
		}
		System.out.println("Choose a dish (enter number from 1 to 5):");
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		input.close();
		System.out.println("Ingredients (for 1 person):");
		for (Ingredient value : service.getIngredients(index)) {
			System.out.println(value);
		}
	}
	
}
