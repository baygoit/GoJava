
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
	
	public void showProject() {
		System.out.println(getTitle());
		System.out.println(getShortDescr());
		System.out.println("Money needed: " + getProjectValue() + "; Money collected: " + getRecievedMoney());
		System.out.println("Days left: " + getDaysLeft());
		System.out.println(descr.getProjectStory());
		System.out.println(descr.getLink());
		System.out.println("--------------------------");
		faq.showFAQ();
		
		System.out.println("0 - Go back");
	}

}
