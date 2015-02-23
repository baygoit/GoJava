package myRealization;

import java.util.HashMap;
import java.util.Map;

public class Project {
	private String nameOfProject;
	private String description;
	private int moneyNeed;
	private int moneyHas;
	private int daysLeft;
	private Category category;
	private String history;
	private String videoLink;
	private String questions;
	private int FIRST_SUM = 1;
	private int SECOND_SUM = 10;
	private int THIRD_SUM = 40;
	private Map<Integer, String> payments = new HashMap<>();
	private String bonus1$;
	private String bonus10$;
	private String bonus40$; 
	
	public Project(Category category){
		this.category = category;
	}
	
	public Category getCategory(){
		return category;
	}
	
	public void setProject(String nameOfProject, String description, int moneyNeed, int moneyHas, int daysLeft, String history, String videoLink,
			String questions){
		this.nameOfProject = nameOfProject;
		this.description = description;
		this.moneyNeed = moneyNeed;
		this.moneyHas = moneyHas;
		this.daysLeft = daysLeft;
		this.history = history;
		this.videoLink = videoLink;
		this.questions = questions;
	}
	
	public String getProjectName(){
		return nameOfProject;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getMoneyNeed(){
		return moneyNeed;
	}
	
	public void increaseMoneyHas(int moneyHas) {
		this.moneyHas += moneyHas;
	}
	
	public int getMoneyHas(){
		return moneyHas;
	}
	
	public int getDaysLeft(){
		return daysLeft;
	}
	
	public String getHistory(){
		return history;
	}
	
	public String getVideoLink(){
		return videoLink;
	}
	
	public String getQuestion(){
		return questions;
	}
	
	public void addClientQuestion(String question){
		questions += "\nQ: " + question;
	}
	
	public void setBonuses(String bonus1$, String bonus10$, String bonus40$){
		this.bonus1$ = bonus1$;
		this.bonus10$ = bonus10$;
		this.bonus40$ = bonus40$;
	}
	
	public void putPayments(){
		payments.put(FIRST_SUM, informForNoBonuses(bonus1$));
		payments.put(SECOND_SUM, informForNoBonuses(bonus10$));
		payments.put(THIRD_SUM, informForNoBonuses(bonus40$));
	}

	public String informForNoBonuses(String bonus) {
		return bonus != null ? bonus : "nothing=(";
	}
	
	public Map<Integer, String> getPayments(){
		putPayments();
		return payments;
	}
	
}
