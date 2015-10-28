package ua.com.goit.gojava.poznyak;

/**
 * The Ingredient bean.
 * 
 * This bean implements the ingredient image.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class Ingredient {
	
	private Foodstuff foodstuff;
	
	private Integer weight;
	
	public Ingredient() {}

	protected Ingredient(Foodstuff foodstuff, Integer weight) {
		this.foodstuff = foodstuff;
		this.weight = weight;
	}

	public Foodstuff getFoodstuff() {
		return foodstuff;
	}

	public void setFoodstuff(Foodstuff foodstuff) {
		this.foodstuff = foodstuff;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}
