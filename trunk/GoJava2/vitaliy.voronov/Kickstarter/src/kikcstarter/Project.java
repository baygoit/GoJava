package kikcstarter;

public class Project {
	private String name;
	private String description;
	private int needMoney;
	private int haveMoney;
	private int daysBeforeEnd;
	private Category category;
	
	public Project(String name, String description, Category category, int needMoney,
			int haveMoney, int daysBeforeEnd) {
	
		this.name = name;
		this.description = description;
		this.category = category;
		this.needMoney = needMoney;
		this.haveMoney = haveMoney;
		this.daysBeforeEnd = daysBeforeEnd;
	}
	
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getNeedMoney() {
		return needMoney;
	}
	public int getHaveMoney() {
		return haveMoney;
	}
	public int getDaysBeforeEnd() {
		return daysBeforeEnd;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String toString(){
		return name;
	}
	
	
	
	
}
