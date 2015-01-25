package myRealization;

public class Project {
	private String nameOfProject;
	private String description;
	private int moneyNeed;
	private int moneyHas;
	private int daysLeft;
	private Category category;
	
	public Project(Category category){
		this.category = category;
	}
	
	public Category getCategory(){
		return category;
	}
	
	public void setProject(String nameOfProject, String description, int moneyNeed, int moneyHas, int daysLeft){
		this.nameOfProject = nameOfProject;
		this.description = description;
		this.moneyNeed = moneyNeed;
		this.moneyHas = moneyHas;
		this.daysLeft = daysLeft;
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
	
	public int getMoneyHas(){
		return moneyHas;
	}
	
	public int getDaysLeft(){
		return daysLeft;
	}
}
