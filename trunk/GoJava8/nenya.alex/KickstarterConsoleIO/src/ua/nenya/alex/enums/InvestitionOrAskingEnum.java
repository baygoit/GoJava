package ua.nenya.alex.enums;

import ua.nenya.alex.project.GetingNameInterface;

public enum InvestitionOrAskingEnum implements GetingNameInterface{
	INVEST_IN_PROJECT("Invest in project"),
	ASK_A_QUESTION("Ask a question");
	
	private String name;

	InvestitionOrAskingEnum(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
