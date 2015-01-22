package ua.com.goit.gojava.poznyak;

import java.util.List;

/**
 * This is the service interface
 * 
 * @version 0.03 22 Jan 2015
 * @author Sergey Poznyak
 */
public interface ListService {
	
	List<Dish> getDishList();
	
	List<Ingredient> getIngredientList(int dishId);
	
}
