package ua.com.goit.gojava.poznyak;

import java.util.List;

/**
 * This is the service interface
 * 
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public interface ListService {
	
	List<Dish> getDishes();
	
	List<Ingredient> getIngredients(int dishId);
	
}
