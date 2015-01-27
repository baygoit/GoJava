package kickstarter_gk;

public class Projects {

	private String name;
	private String desc;
	private double donated;
	private double total;
	private int days;
	private Category category;
	private Info info; 
	
	public Projects(String name, String desc, double total, int days, Info info) {
    donated = 0;
	this.name = name;
	this.desc = desc;
	this.total = total;
	this.days = days;
	this.info = info;
	
	}
	
	public String getName() {
		return name;
	}
	
	public String gesDesc() {
		return desc;
	}
	
	public double getTotal() {
		return total;
	}
	
	public double getDonated() {
		return donated;	
	}
	
	public int getDays() {
		return days;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Info getInfo() {
		return info;
	}
	
}
