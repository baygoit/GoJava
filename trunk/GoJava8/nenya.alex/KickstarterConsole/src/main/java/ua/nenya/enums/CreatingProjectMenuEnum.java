package ua.nenya.enums;

import ua.nenya.project.GettingNameInterface;

public enum CreatingProjectMenuEnum implements GettingNameInterface{
	ENTER_NAME("Enter name"),
	ENTER_DESCRIPTION("Enter description"),
	ENTER_AMOUNT_OF_MONEY("Enter amoun of money"),
	ENTER_AMOUNT_OF_DAYS("Enter amount of days");

	private String name;

	CreatingProjectMenuEnum(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
