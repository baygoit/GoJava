package ua.com.goit.gojava.poznyak;

/**
 * The Ingredient bean.
 * 
 * This class implements the ingredient image
 * 
 * @version 0.04 28 Jan 2015
 * @author Sergey Poznyak
 */
public class Ingredient {
	
	private Dish dish;
	
	private Foodstuff foodstuff;
	
	private Integer weight;
	
	public Ingredient() {}

	protected Ingredient(Dish dish, Foodstuff foodstuff, int weight) {
		this.dish = dish;
		this.foodstuff = foodstuff;
		this.weight = weight;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Foodstuff getFoodstuff() {
		return foodstuff;
	}

	public void setFoodstuff(Foodstuff foodstuff) {
		this.foodstuff = foodstuff;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return weight.toString();
	}
	
}
