package ua.com.goit.gojava.poznyak;

import java.util.List;
import java.util.Map;

/**
 * This class implements the service interface
 * 
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public class ListServiceImplementation implements ListService {
	
	private static final List<Dish> DISHES_LIST = DishStorage.createDishes();
	
	private static final Map<Integer, List<Ingredient>> INGREDIENTS_LIST = DishStorage.createIngredients();

	@Override
	public List<Dish> getDishes() {
		return DISHES_LIST;
	}

	@Override
	public List<Ingredient> getIngredients(int dishId) {
		return INGREDIENTS_LIST.get(dishId);
	}
	
}
