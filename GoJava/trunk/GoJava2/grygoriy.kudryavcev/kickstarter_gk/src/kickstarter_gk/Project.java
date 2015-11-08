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
	
	public double setDonated(float donated) {
		
		this.donated += donated;;
		
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
		return name + ", " + desc + ", total:" + total + ", donated: " + donated + ", days to start: " + days;
	}
	
	public String outLong(){

		return outShort() + " Description project: " + description + " History: " + history + " Video: " + linkVideo;
		
	}
	
	
}
