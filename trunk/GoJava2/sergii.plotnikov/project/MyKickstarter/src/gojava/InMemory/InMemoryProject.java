package gojava.InMemory;

import gojava.Payment;
import gojava.Reward;
import gojava.Interface.Description;
import gojava.Interface.FAQ;
import gojava.Interface.Payments;
import gojava.Interface.Project;

import java.util.*;

public class InMemoryProject implements Project {
	private Description descr;
	private Map <Integer, Object> positions;
	
	private int projectValue;
	private int recievedMoney;
	private int daysLeft;
		
	public InMemoryProject(String title){ 
		descr = new InMemoryDescription(title);
		positions = new HashMap<Integer, Object>();
		projectValue=10000;
		recievedMoney=0;
		daysLeft=7;	
		positions.put(0, new InMemoryFAQ());
		positions.put(1, new InMemoryPayments());
	}
	
	@Override
	public String getTitle(){ return descr.getTitle();}
	@Override
	public String getShortDescr() { return descr.getShortDescr();}

	@Override
	public int getPositionsLength() { return positions.size();}

	public FAQ getFaq(){ return (FAQ) positions.get(0);}
	@Override
	public void addQuestion(String q){ getFaq().addQuestion(q);}
	@Override
	public Payments getPayments(){ return (Payments) positions.get(1);}
	
	@Override
	public int getRewardsLength() { return getPayments().getRewardsLength();}
	@Override
	public int getRewardPrice(int i) { 
		Reward temp = (Reward)getPayments().getReward(i);
		return temp.getAmount();
	}
	
	@Override
	public void makePayment(Payment p, int amount) {
		recievedMoney+=amount;
		getPayments().makePayment(p);
	}	
	
	@Override
	public String shortProjectDescr(){
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + projectValue + "; Money collected: " + recievedMoney+"\n";
		result+="Days left: " + daysLeft+"\n";
		result+="--------------------------"+"\n";
		return result;
	}
	
	@Override
	public String showProject() {
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + projectValue + "; Money collected: " + recievedMoney+"\n";
		result+="Days left: " + daysLeft+"\n";
		result+=descr.getProjectStory()+"\n";
		result+=descr.getLink()+"\n";
		result+=getFaq().showFAQ();
		result+="--------------------------"+"\n";
		result+="1 - Ask question\n2 - Invest\n0 - Go back\n";
		
		return result;
	}
}
