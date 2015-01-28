package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides with the service
 * which calculates weights of foodstuff
 * for the list of dishes.
 * 
 * @version 0.04 28 Jan 2015
 * @author Sergey Poznyak
 */
public class CalculationService {
	
	@SuppressWarnings("serial")
	private static List<Dish> dishList = new ArrayList<Dish>() {{
		List<Dish> dishes = ListServiceHardcodedData.getDishList();
		this.add(dishes.get(1));
		this.add(dishes.get(1));
		this.add(dishes.get(1));
	}};
	
	public static Map<Foodstuff, Double> calculateWeights() {
		Map<Foodstuff, Double> result = new HashMap<Foodstuff, Double>();
		List<Foodstuff> foodstuffList = ListServiceHardcodedData.getFoodstuffList();
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		double currentWeight = 0.0;
		for (Dish dish : dishList) {
			ingredientList.addAll(ListServiceHardcodedData.getIngredientList(dish));
		}
		for (Foodstuff foodstuff : foodstuffList) {
			for (Ingredient ingred : ingredientList) {
				if (ingred.getFoodstuff().equals(foodstuff)) {
					currentWeight += ingred.getWeight();
				}
			}
			if (currentWeight > 0.0) {
				result.put(foodstuff, currentWeight);
			}
			currentWeight = 0.0;
		}
		return result;
	}

}
