package gojava;

import java.util.*;

public class Project {
	private Description descr;
	private Map <Integer, Object> positions;
	
	private int projectValue;
	private int recievedMoney;
	private int daysLeft;
		
	public Project(String title){ 
		descr = new Description();
		positions = new HashMap<Integer, Object>();
		descr.initTitle(title);
		projectValue=10000;
		recievedMoney=0;
		daysLeft=7;	
		positions.put(0, new FAQ());
		positions.put(1, new Payments());
	}
	
	public String getTitle(){ return descr.getTitle();}
	public String getShortDescr() { return descr.getShortDescr();}

	public int getPositionsLength() { return positions.size();}

	public FAQ getFaq(){ return (FAQ) positions.get(0);}
	public void addQuestion(String q){ getFaq().addQuestion(q);}
	
	public Payments getPayments(){ return (Payments) positions.get(1);}
	
	public int getRewardsLength() { return getPayments().getRewardsLength();}
	public int getRewardPrice(int i) { return getPayments().getReward(i).getAmount();}
	public String showRewards() { return getPayments().showRewards();}
	
	public void makePayment(Payment p, int amount) {
		recievedMoney+=amount;
		getPayments().makePayment(p);
	}	
	
	public String shortProjectDescr(){
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + projectValue + "; Money collected: " + recievedMoney+"\n";
		result+="Days left: " + daysLeft+"\n";
		result+="--------------------------"+"\n";
		return result;
	}
	
	public String showProject() {
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + projectValue + "; Money collected: " + recievedMoney+"\n";
		result+="Days left: " + daysLeft+"\n";
		result+=descr.getProjectStory()+"\n";
		result+=descr.getLink()+"\n";
		result+="--------------------------"+"\n";
		result+=getFaq().showFAQ();
		result+="1 - Ask question\n2 - Invest\n0 - Go back\n";
		
		return result;
	}
}
