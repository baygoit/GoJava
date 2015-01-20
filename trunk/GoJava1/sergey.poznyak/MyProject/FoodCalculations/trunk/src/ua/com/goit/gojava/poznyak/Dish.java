package ua.com.goit.gojava.poznyak;

/**
 * This class implements the dish
 * @version 0.02 19 Jan 2015
 * @author Sergey Poznyak
 */
public class Dish {
	
	private static int nextId = 1;
	
	private int id;
	
	private String name;
	
	public Dish(String dishName) {
		id = nextId;
		nextId++;
		name = dishName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return id + ". " + name;
	}
	
}
