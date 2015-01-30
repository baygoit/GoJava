package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements the listing service.
 * 
 * @version 0.04 28 Jan 2015
 * @author Sergey Poznyak
 */
public class ListServiceHardcodedData {
	
	@SuppressWarnings("serial")
	private static List<Foodstuff> foodstuffList = new ArrayList<Foodstuff>() {{
		this.add(new Foodstuff("buckwheat"));
		this.add(new Foodstuff("salt"));
		this.add(new Foodstuff("stew"));
	}};
	
	@SuppressWarnings("serial")
	private static List<Dish> dishList = new ArrayList<Dish>() {{
		this.add(new Dish(1, "Borshch"));
		this.add(new Dish(2, "Buckwheat porridge"));
		this.add(new Dish(3, "Rice porridge"));
		this.add(new Dish(4, "Buckwheat soup"));
		this.add(new Dish(5, "Pasta with meat"));
	}};
	
	@SuppressWarnings("serial")
	private static List<Ingredient> ingredientList = new ArrayList<Ingredient>() {{
		this.add(new Ingredient(dishList.get(1), foodstuffList.get(0), 80));
		this.add(new Ingredient(dishList.get(1), foodstuffList.get(1), 5));
		this.add(new Ingredient(dishList.get(1), foodstuffList.get(2), 125));
	}};
	
	
	public static List<Foodstuff> getFoodstuffList() {
		return foodstuffList;
	}
	
	public static List<Dish> getDishList() {
		return dishList;
	}

	public static List<Ingredient> getIngredientList(Dish dish) {
		List<Ingredient> result = new ArrayList<Ingredient>();
		for (Ingredient value : ingredientList) {
			if (Objects.equals(value.getDish(), dish)) {
				result.add(value);
			}
		}
		return result;
	}
	
}
