package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the service interface
 * 
 * @version 0.03 22 Jan 2015
 * @author Sergey Poznyak
 */
public class ListServiceHardcodedData implements ListService {
	
	private List<Dish> dishesList = new ArrayList<Dish>();
	
	private Map<Integer, List<Ingredient>> ingredientsList = new HashMap<Integer, List<Ingredient>>();

	@Override
	public List<Dish> getDishList() {
		dishesList.add(new Dish(1, "Borshch"));
		dishesList.add(new Dish(2, "Buckwheat porridge"));
		dishesList.add(new Dish(3, "Rice porridge"));
		dishesList.add(new Dish(4, "Buckwheat soup"));
		dishesList.add(new Dish(5, "Pasta with meat"));
		return dishesList;
	}

	@Override
	public List<Ingredient> getIngredientList(int dishId) {
		List<Ingredient> currentDish = new ArrayList<Ingredient>();
		ingredientsList.put(2, currentDish);
		currentDish.add(new Ingredient("buckwheat", 0.08));
		currentDish.add(new Ingredient("salt", 0.005));
		currentDish.add(new Ingredient("stew", 0.125));
		List<Ingredient> result = ingredientsList.get(dishId);
		if (result == null) {
			return new ArrayList<Ingredient>();
		}
		return result;
	}
	
}
