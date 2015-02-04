package gojava;

import java.util.LinkedList;
import java.util.List;

public class Project {
	
	private Description descr = new Description();
	private FAQ myFaq = new FAQ();
	private List <Payment> payments = new LinkedList<Payment>();
	
	int positions=2;
	
	private int projectValue;
	private int recievedMoney;
	private int daysLeft;
		
	public Project(String title){ 
		descr.initTitle(title);
		projectValue=10000;
		recievedMoney=0;
		daysLeft=7;	
	}
	
	public String getTitle(){ return descr.getTitle();}

	public String getShortDescr() {	return descr.getShortDescr();}
	
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
		result+=myFaq.showFAQ();
		result+="1 - Ask question\n2 - Invest\n0 - Go back\n";
		
		return result;
	}
	
	public void addQuestion(String q){
		myFaq.addQuestion(q);
	}

	public void makePayment(Payment p, int amount) {
		recievedMoney+=amount;
		payments.add(p);		
	}
	
	

}
