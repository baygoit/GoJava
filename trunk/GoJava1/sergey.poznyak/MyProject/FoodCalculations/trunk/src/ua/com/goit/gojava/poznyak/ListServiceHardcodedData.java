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
	
	@SuppressWarnings("serial")
	private List<Dish> dishesList = new ArrayList<Dish>() {{
		this.add(new Dish(1, "Borshch"));
		this.add(new Dish(2, "Buckwheat porridge"));
		this.add(new Dish(3, "Rice porridge"));
		this.add(new Dish(4, "Buckwheat soup"));
		this.add(new Dish(5, "Pasta with meat"));
	}};
	
	@SuppressWarnings("serial")
	private Map<Integer, List<Ingredient>> ingredientsList = new HashMap<Integer, List<Ingredient>>() {{
		List<Ingredient> currentDish = new ArrayList<Ingredient>();
		this.put(2, currentDish);
		currentDish.add(new Ingredient("buckwheat", 0.08));
		currentDish.add(new Ingredient("salt", 0.005));
		currentDish.add(new Ingredient("stew", 0.125));
	}};

	@Override
	public List<Dish> getDishList() {
		return dishesList;
	}

	@Override
	public List<Ingredient> getIngredientList(int dishId) {
		List<Ingredient> result = ingredientsList.get(dishId);
		if (result == null) {
			return new ArrayList<Ingredient>();
		}
		return result;
	}
	
}
