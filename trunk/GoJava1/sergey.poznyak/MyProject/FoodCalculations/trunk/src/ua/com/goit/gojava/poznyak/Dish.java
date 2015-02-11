package ua.com.goit.gojava.poznyak;

import java.util.List;

/**
 * The Dish bean.
 * 
 * This bean implements the dish image.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class Dish {
	
	private Integer id;
	
	private String name;
	
	private List<Ingredient> ingredients;

	public Dish() {}
	
	protected Dish(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> dishIngredients) {
		this.ingredients = dishIngredients;
	}

}
