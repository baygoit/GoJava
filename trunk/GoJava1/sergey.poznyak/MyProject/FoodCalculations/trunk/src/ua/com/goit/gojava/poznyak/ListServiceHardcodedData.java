package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the listing service.
 * 
 * @version 0.1 11 Feb 2015
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
		this.get(1).setIngredients(new ArrayList<Ingredient>() {{ 
		                this.add(new Ingredient(foodstuffList.get(0), 80));
		                this.add(new Ingredient(foodstuffList.get(1), 5));
		                this.add(new Ingredient(foodstuffList.get(2), 125));
		                }});
		this.add(new Dish(3, "Rice porridge"));
		this.add(new Dish(4, "Buckwheat soup"));
		this.add(new Dish(5, "Pasta with meat"));
	}};
	
	public static List<Foodstuff> getFoodstuffList() {
		return foodstuffList;
	}
	
	public static List<Dish> getDishList() {
		return dishList;
	}
	
}
