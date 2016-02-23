package ua.nenya.alex.pages;

import ua.nenya.alex.project.GetNameInterface;

public enum InvestAndAskEnum implements GetNameInterface{
	INVEST_IN_PROJECT("Invest in project"),
	ASK_A_QUESTION("Ask a question");
	
	private String name;

	InvestAndAskEnum(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
