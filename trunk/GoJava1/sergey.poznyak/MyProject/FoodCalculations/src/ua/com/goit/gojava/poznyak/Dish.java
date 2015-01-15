package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;

/**
 * This class implements the dish
 * @version 0.01 15 Jan 2015
 * @author Sergey Poznyak
 */
public class Dish {
	private String name;
	private ArrayList<Product> productsList;
	
	public Dish(String dishName) {
		name = dishName;
		productsList = new ArrayList<Product>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Product> getProductsList() {
		return productsList;
	}
	
	/**
	 * Adds new product to the products list
	 * via calling Product constructor
	 */
	public void addProduct(String prodName, double prodWeight) {
		productsList.add(new Product(prodName, prodWeight));
	}
}
