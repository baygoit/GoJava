package ua.com.goit.gojava.poznyak;

/**
 * The Dish bean.
 * 
 * This bean implements the dish image.
 * 
 * @version 0.04 28 Jan 2015
 * @author Sergey Poznyak
 */
public class Dish {
	
	private Integer id;
	
	private String name;

	public Dish() {}
	
	protected Dish(int dishId, String dishName) {
		id = dishId;
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
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ". " + name;
	}
	
}
