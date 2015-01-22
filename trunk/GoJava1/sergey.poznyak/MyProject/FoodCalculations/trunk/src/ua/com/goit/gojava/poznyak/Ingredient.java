package ua.com.goit.gojava.poznyak;

/**
 * The Ingredient bean.
 * 
 * This class implements the ingredient image
 * @version 0.03 22 Jan 2015
 * @author Sergey Poznyak
 */
public class Ingredient {
	
	private String name;
	
	private double weight;
	
	public Ingredient() {
		name = "";
		weight = 0.0;
	}

	public Ingredient(String ingrName, double ingrWeight) {
		name = ingrName;
		weight = ingrWeight;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name + " x " + weight + "kg";
	}
	
}
