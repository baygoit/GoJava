package kickstarter.entities;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 5586320940365035555L;
	private String name;
	private int ID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Category(String name) {
		this.name = name;
	}
}
