package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class stores the dishes and theirs ingredients
 * 
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public class DishStorage {
	
	public static List<Dish> createDishes() {
		List<Dish> result = new ArrayList<Dish>();
		result.add(new Dish("Borshch"));
		result.add(new Dish("Buckwheat porridge"));
		result.add(new Dish("Rice porridge"));
		result.add(new Dish("Buckwheat soup"));
		result.add(new Dish("Pasta with meat"));
		return result;
	}
	
	public static Map<Integer, List<Ingredient>> createIngredients() {
		Map<Integer, List<Ingredient>> result = new HashMap<Integer, List<Ingredient>>();
		List<Ingredient> currentDish = new ArrayList<Ingredient>();
		result.put(2, currentDish);
		currentDish.add(new Ingredient("buckwheat", 0.08));
		currentDish.add(new Ingredient("salt", 0.005));
		currentDish.add(new Ingredient("stew", 0.125));
		return result;
	}

}
