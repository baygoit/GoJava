package ua.com.goit.gojava.kickstarter.in_memory_storage;


import java.io.Serializable;
import java.util.Date;

public class ProjectParameters implements Serializable {
	private static final int TRANSITION_COEFFICIENT_SECONDS_TO_DAYS = 86400;
	private int cost;
	private int alreadyCollected;
	private long daysLeft;
	private DetailedParameters dParam = new DetailedParameters();

	public ProjectParameters(int cost, int collected, Date date,
			String history, String demo, String faq) {
	this.cost=cost;
	alreadyCollected=collected;
	Date currentDate = new Date();
	//TODO Improve date operations
	//daysLeft = (date.getTime()-currentDate.getTime())/TRANSITION_COEFFICIENT_SECONDS_TO_DAYS;
	if(history!=null&&demo!=null&&faq!=null){
	dParam = new DetailedParameters(history,demo,faq);
	}
	}


	public ProjectParameters() {
		// TODO Auto-generated constructor stub
	}


	public void setCost(int cost) {
		this.cost = cost;

	}
	

	public long getDays() {
		return daysLeft;
	}

	public void setAlreadyCollected(int collected) {
		alreadyCollected = collected;

	}

	public int getCost() {
		return cost;
	}

	public int getAlreadyCollected() {
		return alreadyCollected;
	}

	public void addAlreadyCollected(int num) {
		alreadyCollected += num;
	}

	public void setDays(int days) {
		daysLeft = days;

	}

	public class DetailedParameters implements Serializable {
		private String history;
		private Link demo;
		private Link faq;

		private DetailedParameters() {
			history = "\n*history**history**history*\n"
					+ "history**history**history*\n"
					+ "history**history**history*";
			demo = new Link("demoURL");
			faq = new Link("faqURL");
		}
		

		public DetailedParameters(String history, String demo, String faq) {
			this.demo=new Link(demo);
			this.faq=new Link(faq);
			this.history=history;
		}


		public String getHisory() {
			return history;
		}

		public String getDemoLink() {
			return demo.getUrl();
		}

		public String getFaqLink(){
			return faq.getUrl();
		}
	}

	public DetailedParameters getDetailedParameters() {
		return dParam;
	}

}
