/**
 * Created by Sergey Poznyak on 15.01.2015
 * 
 * This program provides with the food calculations for hiking
 */
package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class.
 * 
 * @version 0.05 03 Feb 2015
 * @author Sergey Poznyak
 */
public class FoodCalculations {

	/**
	 * Calls the displaying methods
	 * and provides with possibility to input
	 * the number of chosen dish
	 * @param args
	 */
	public static void main(String[] args) throws IndexOutOfBoundsException {
		System.out.println("Menu:");
		List<Dish> dishes = ListServiceHardcodedData.getDishList();
		displayDishes(dishes);
		System.out.println("Choose a dish (enter its number):");
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		input.close();
		System.out.println("Ingredients (for 1 person):");
		try {
			displayIngredients(dishes.get(index - 1).getIngredients());
		} catch(IndexOutOfBoundsException e) {
			System.out.println("No such dish");
		}
		List<Dish> dishMenu = new ArrayList<Dish>();
		dishMenu.add(dishes.get(1));
		dishMenu.add(dishes.get(1));
		dishMenu.add(dishes.get(1));
		UserMenu menu = new UserMenu(7, dishMenu);
		System.out.println(menu);
	}
	
	/**
	 * Prints the list of dishes into the console.
	 * @param dishes is the list of Dish instances
	 */
	public static void displayDishes(List<Dish> dishes) {
		if (dishes == null || dishes.isEmpty()) {
			System.out.println("There are no dishes.");
		}
		for (Dish value : dishes) {
			System.out.println(value);
		}
	}
	
	/**
	 * Prints the list of required ingredients
	 * for the chosen dish
	 * @param ingredients is the list of Ingredient instances
	 */
	public static void displayIngredients(List<Ingredient> ingredients) {
		if (ingredients == null || ingredients.isEmpty()) {
			System.out.println("There are no ingredients for chosen dish.");
		} else {
			for (Ingredient value : ingredients) {
				System.out.println(value.getFoodstuff() + " x " + value
						           + " g");
			}
		}
	}
	
}
