package ua.nenya.enums;

import ua.nenya.project.GetingNameInterface;

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
