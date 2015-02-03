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
 * @version 0.05 03 Feb 2015
 * @author Sergey Poznyak
 */
public class UserMenu {
	
	private Integer peopleNum;
	
	private List<Dish> dishList;
	
	public UserMenu() {
		dishList = new ArrayList<Dish>();
	}
	
	protected UserMenu(Integer peopleNum, List<Dish> dishList) {
		this.peopleNum = peopleNum;
		this.dishList = dishList;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	public List<Dish> getDishList() {
		return dishList;
	}

	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}
	
	public void addDsih(Dish dish) {
		if (dish != null) {
			dishList.add(dish);
		}
	}
	
	public Map<Foodstuff, Integer> calculateWeights() {
		Map<Foodstuff, Integer> result = new HashMap<Foodstuff, Integer>();
		List<Foodstuff> foodstuffList = ListServiceHardcodedData.getFoodstuffList();
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		int currentWeight = 0;
		for (Dish dish : dishList) {
			List<Ingredient> dishIngredients = dish.getIngredients();
			if (dishIngredients != null && !dishIngredients.isEmpty()) {
				ingredientList.addAll(dishIngredients);
			}
		}
		for (Foodstuff foodstuff : foodstuffList) {
			for (Ingredient ingred : ingredientList) {
				if (ingred.getFoodstuff() == foodstuff) {
					currentWeight += (ingred.getWeight() * peopleNum);
				}
			}
			if (currentWeight > 0) {
				result.put(foodstuff, currentWeight);
			}
			currentWeight = 0;
		}
		return result;
	}

	@Override
	public String toString() {
		return "User's menu:\n" + "Number of people: " + peopleNum + "\n"
	            + "List of dishes:\n" + dishList + "\n"
				+ "Ingredients needed:\n" + calculateWeights() + "\n";
	}

}
