package ua.nenya.enums;

import ua.nenya.project.GettingNameInterface;

public enum InvestitionOrAskingEnum implements GettingNameInterface{
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
