package ua.com.goit.gojava.poznyak;

/**
 * The Foodstuff bean.
 * 
 * This bean implements the foodstuff image.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class Foodstuff {
	
	private String name;
	
	public Foodstuff() {}
	
	protected Foodstuff(String foodstuffName) {
		name = foodstuffName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
