package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class stores the dishes and theirs ingredients
 * 
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public class DishStorage {
	
	private static AtomicInteger dishesCounter = new AtomicInteger(0);
	
	public static List<Dish> createDishes() {
		List<Dish> result = new ArrayList<Dish>();
		result.add(new Dish(dishesCounter.incrementAndGet(), "Borshch"));
		result.add(new Dish(dishesCounter.incrementAndGet(), "Buckwheat porridge"));
		result.add(new Dish(dishesCounter.incrementAndGet(), "Rice porridge"));
		result.add(new Dish(dishesCounter.incrementAndGet(), "Buckwheat soup"));
		result.add(new Dish(dishesCounter.incrementAndGet(), "Pasta with meat"));
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
