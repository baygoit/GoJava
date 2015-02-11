package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Eating bean.
 * 
 * This bean implements the eating image.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class Eating {
	
	private List<Dish> dishList;
	
	private List<Ingredient> ingredientList;
	
	public Eating() {}
	
	protected Eating(List<Dish> dishList, List<Ingredient> ingredientList) {
		this.dishList = dishList;
		this.ingredientList = ingredientList;
	}
	
	public boolean addDish(Dish e) {
		return dishList.add(e);
	}

	public Dish getDish(int index) {
		return dishList.get(index);
	}

	public Dish removeDish(int index) {
		return dishList.remove(index);
	}
	
	public boolean addIngredient(Ingredient e) {
		return ingredientList.add(e);
	}

	public Ingredient getIngredient(int index) {
		return ingredientList.get(index);
	}

	public Ingredient removeIngredient(int index) {
		return ingredientList.remove(index);
	}

	/**
	 * Calculates foodstuff weights for one eating.
	 * 
	 * @return Map of required foodstuffs and their weights
	 * @throws FoodCalculationsBLException
	 */
	public Map<Foodstuff, Integer> calculateWeights() throws FoodCalculationsBLException {
		try {
			Map<Foodstuff, Integer> result = new HashMap<Foodstuff, Integer>();
			List<Ingredient> eatingIngredients = new ArrayList<Ingredient>();
			for (Dish dish : dishList) {
				List<Ingredient> dishIngredients = dish.getIngredients();
				if (dishIngredients != null && !dishIngredients.isEmpty()) {
					eatingIngredients.addAll(dishIngredients);
				}
			}
			eatingIngredients.addAll(ingredientList);
			for (Ingredient ingred : eatingIngredients) {
				if (result.containsKey(ingred.getFoodstuff())) {
					result.put(ingred.getFoodstuff(), result.get(ingred.getFoodstuff()) + ingred.getWeight());
				} else {
					result.put(ingred.getFoodstuff(), ingred.getWeight());
				}
			}
			return result;
		} catch (Exception e) {
			throw new FoodCalculationsBLException(e);
		}
	}

}
