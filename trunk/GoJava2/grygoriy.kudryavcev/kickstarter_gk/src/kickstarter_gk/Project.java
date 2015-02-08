package kickstarter_gk;

public class Project {

	private String name;
	private String desc;
	private double donated;
	private double total;
	private int days;
	private Category category;
	private Info info; 
	private String description;
	private String history;
    private String linkVideo;
    private String FAQ;
	
//    ("Project1 name", "Start smthg", 50000, 128, category, "Project info")
    
	public Project(String name, String desc, double total, int days, Category category) {
    donated = 0;
	this.name = name;
	this.desc = desc;
	this.total = total;
	this.days = days;
	this.category = category;
//	this.info = info;
	
	
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
	
	public String outShort(){
		return name + "," + desc + ", total" + total + ", donated" + donated + ", days to start" + days;
	}
	
	public String outLong(){

		return outShort() + "Description project" + description + "History:" + history + "Video:" + linkVideo + "FAQ:" +FAQ;
		
	}
	
	
}
