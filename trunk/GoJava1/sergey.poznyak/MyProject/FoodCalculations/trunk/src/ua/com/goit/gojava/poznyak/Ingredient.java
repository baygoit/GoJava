package ua.com.goit.gojava.poznyak;

/**
 * This class implements the ingredient
 * 
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public class Ingredient {
	
	private String name;
	
	private double weight;
	
	public Ingredient(String ingrName, double ingrWeight) {
		name = ingrName;
		weight = ingrWeight;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return name + " x " + weight + "kg";
	}
	
}
