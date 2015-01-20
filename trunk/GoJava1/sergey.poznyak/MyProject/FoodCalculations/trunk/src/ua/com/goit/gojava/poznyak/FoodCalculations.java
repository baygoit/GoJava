/**
 * Created by Sergey Poznyak on 15.01.2015
 * 
 * This program provides with the food calculations for hiking
 */
package ua.com.goit.gojava.poznyak;

import java.util.List;
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
		displayDishes(service.getDishes());
		System.out.println("Choose a dish (enter its number):");
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		input.close();
		System.out.println("Ingredients (for 1 person):");
		displayIngredients(service.getIngredients(index));
	}
	
	public static void displayDishes(List<Dish> dishes) {
		if (dishes == null || dishes.isEmpty()) {
			System.out.println("There are no dishes.");
		}
		for (Dish value : dishes) {
			System.out.println(value);
		}
	}
	
	public static void displayIngredients(List<Ingredient> ingredients) {
		if (ingredients == null || ingredients.isEmpty()) {
			System.out.println("There are no ingredients for chosen dish.");
		} else {
			for (Ingredient value : ingredients) {
				System.out.println(value);
			}
		}
	}
	
}
