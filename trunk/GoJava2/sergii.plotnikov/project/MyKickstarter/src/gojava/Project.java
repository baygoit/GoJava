package gojava;

public class Project {
	
	private Description descr = new Description();
	private FAQ faq = new FAQ();
	private int projectValue;
	private int recievedMoney;
	private int daysLeft;
		
	public Project(String title){ 
		descr.initTitle(title);
		projectValue=10000;
		recievedMoney=9999;
		daysLeft=7;	
	}
	
	public String getTitle(){ return descr.getTitle();}

	public String getShortDescr() {	return descr.getShortDescr();}

	public int getProjectValue() { return projectValue;}

	public int getRecievedMoney() { return recievedMoney;}
	
	public int getDaysLeft() { return daysLeft;}
	
	public String shortProjectDescr(){
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + getProjectValue() + "; Money collected: " + getRecievedMoney()+"\n";
		result+="Days left: " + getDaysLeft()+"\n";
		return result;
	}
	
	public String showProject() {
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + getProjectValue() + "; Money collected: " + getRecievedMoney()+"\n";
		result+="Days left: " + getDaysLeft()+"\n";;
		result+=descr.getProjectStory()+"\n";;
		result+=descr.getLink()+"\n";;
		result+="--------------------------"+"\n";
		result+=faq.showFAQ();
		
		result+="0 - Go back\n";
		return result;
	}

}
