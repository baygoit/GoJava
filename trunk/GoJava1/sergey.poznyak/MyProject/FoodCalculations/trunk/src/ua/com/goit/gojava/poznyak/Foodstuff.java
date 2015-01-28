package ua.com.goit.gojava.poznyak;

/**
 * The Foodstuff bean.
 * 
 * This class implements the foodstuff image.
 * 
 * @version 0.04 28 Jan 2015
 * @author Sergey Poznyak
 */
public class Foodstuff {
	
	private Integer id;
	
	private String name;
	
	public Foodstuff() {}
	
	protected Foodstuff(int foodstuffId, String foodstuffName) {
		id = foodstuffId;
		name = foodstuffName;
	}

	public Integer getId() {
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
		return name;
	}

}
