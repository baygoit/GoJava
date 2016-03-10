package ua.nenya.alex.enums;

import ua.nenya.alex.project.GetingNameInterface;

public enum CreatingProjectMenuEnum implements GetingNameInterface{
	ENTER_NAME("Enter name"),
	ENTER_DESCRIPTION("Enter description"),
	ENTER_AMOUNT_OF_MONEY("Enter amoun of money"),
	ENTER_AMOUNT_OF_DAYS("Enter amount of days"),
	ENTER_CATEGORY("Enter category");

	private String name;

	CreatingProjectMenuEnum(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
