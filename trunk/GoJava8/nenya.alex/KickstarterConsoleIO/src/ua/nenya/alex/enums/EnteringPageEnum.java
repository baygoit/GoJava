package ua.nenya.alex.enums;

import ua.nenya.alex.project.GetNameInterface;

public enum EnteringPageEnum implements GetNameInterface{
	ENTER("Enter"),
	REGISTRATION("Registration");
	
	String name;

	private EnteringPageEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
