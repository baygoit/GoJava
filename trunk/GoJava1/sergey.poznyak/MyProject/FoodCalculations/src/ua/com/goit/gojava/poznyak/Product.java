package ua.com.goit.gojava.poznyak;

/**
 * This class implements the product
 * 
 * @version 0.01 15 Jan 2015
 * @author Sergey Poznyak
 */
public class Product {
	private String name;
	private double weight;
	
	public Product(String prodName, double prodWeight) {
		name = prodName;
		weight = prodWeight;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String toString() {
		return name + " x " + weight + "Í„";
	}
}
