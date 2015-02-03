package ua.com.goit.gojava.poznyak;

/**
 * The Foodstuff bean.
 * 
 * This class implements the foodstuff image.
 * 
 * @version 0.05 03 Feb 2015
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

	@Override
	public String toString() {
		return name;
	}

}
