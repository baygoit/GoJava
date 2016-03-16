package ua.nenya.enums;

import ua.nenya.project.GettingNameInterface;

public enum EnteringPageEnum implements GettingNameInterface{
	GO_TO_CATEGORIES("Go to categories"),
	CREATE_NEW_PROJECT("Create new project");
	
	String name;

	private EnteringPageEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
