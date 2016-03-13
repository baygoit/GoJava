package ua.nenya.enums;

import ua.nenya.project.GetingNameInterface;

public enum EnteringPageEnum implements GetingNameInterface{
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
