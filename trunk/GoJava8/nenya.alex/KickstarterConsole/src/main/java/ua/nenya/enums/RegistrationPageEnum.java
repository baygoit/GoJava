package ua.nenya.enums;

import ua.nenya.project.GettingNameInterface;

public enum RegistrationPageEnum implements GettingNameInterface{
	ENTER("Enter"),
	REGISTRATION("Registration");
	
	String name;

	private RegistrationPageEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
