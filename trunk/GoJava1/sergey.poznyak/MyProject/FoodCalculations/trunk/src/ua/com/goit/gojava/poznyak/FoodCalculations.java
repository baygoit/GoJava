/**
 * Created by Sergey Poznyak on 15.01.2015
 * 
 * This program provides with the food calculations for hiking
 */
package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The main class.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class FoodCalculations {

	/**
	 * Calls the displaying methods
	 * and provides with possibility to input
	 * the number of chosen dish.
	 * 
	 * @param args
	 * @throws FoodCalculationsBLException 
	 */
	public static void main(String[] args) throws FoodCalculationsBLException {
		System.out.println("Menu:");
		List<Dish> dishes = ListServiceHardcodedData.getDishList();
		displayDishes(dishes);
		System.out.println("Choose a dish (enter its number):");
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		input.close();
		System.out.println("Ingredients (for 1 person):");
		if (index >= dishes.size() || index < 0) {
			System.out.println("No such dish");
		} else {
			displayIngredients(dishes.get(index - 1).getIngredients());
		}
		List<Dish> dishMenu = new ArrayList<Dish>();
		dishMenu.add(dishes.get(1));
		dishMenu.add(dishes.get(1));
		dishMenu.add(dishes.get(1));
		Eating eating = new Eating(dishMenu, dishes.get(1).getIngredients());
		System.out.println("Ingredients for eating:");
		Map<Foodstuff, Integer> eatingWeights = eating.calculateWeights();
		for (Foodstuff key : eatingWeights.keySet()) {
			System.out.println(key.getName() + " = " + eatingWeights.get(key));
		}
		Day day = new Day();
		day.add(eating);
		day.add(eating);
		System.out.println("Ingredients for day:");
		Map<Foodstuff, Integer> dayWeights = day.calculateWeights();
		for (Foodstuff key : dayWeights.keySet()) {
			System.out.println(key.getName() + " = " + dayWeights.get(key));
		}
		Schedule schedule = new Schedule();
		schedule.add(day);
		schedule.add(day);
		schedule.add(day);
		System.out.println("Ingredients for schedule:");
		Map<Foodstuff, Integer> scheduleWeights = schedule.calculateWeights();
		for (Foodstuff key : scheduleWeights.keySet()) {
			System.out.println(key.getName() + " = " + scheduleWeights.get(key));
		}
	}
	
	/**
	 * Prints the list of dishes into the console.
	 * 
	 * @param dishes is the list of Dish instances
	 */
	public static void displayDishes(List<Dish> dishes) {
		if (dishes == null || dishes.isEmpty()) {
			System.out.println("There are no dishes.");
		} else {
			int number = 1;
			for (Dish value : dishes) {
				System.out.println(number + ". " + value.getName());
				number++;
			}
		}
	}
	
	/**
	 * Prints the list of required ingredients
	 * for the chosen dish.
	 * 
	 * @param ingredients is the list of Ingredient instances
	 */
	public static void displayIngredients(List<Ingredient> ingredients) {
		if (ingredients == null || ingredients.isEmpty()) {
			System.out.println("There are no ingredients for chosen dish.");
		} else {
			for (Ingredient value : ingredients) {
				System.out.println(value.getFoodstuff().getName() + " x "
			                       + value.getWeight() + " g");
			}
		}
	}
	
}
