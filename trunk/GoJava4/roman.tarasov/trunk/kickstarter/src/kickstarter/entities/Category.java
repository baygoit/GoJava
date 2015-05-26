package kickstarter.entities;

import java.io.Serializable;



public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5586320940365035555L;
	public String name;
	public int ID;

	public Category(String name) {
		this.name = name;
	}
}
