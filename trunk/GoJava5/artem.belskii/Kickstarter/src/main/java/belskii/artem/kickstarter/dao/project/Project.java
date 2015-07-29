package belskii.artem.kickstarter.dao.project;

public class Project {
	private String name;
	private Long goal;
	private Long balance;
	private String startDate; 
	private String endDate;
	private String videoUrl;
	private int categoryId;
	
	public Project(String name, Long goal, Long balance, String startDate, String endDate, String videoUrl, int categoryId){
		this.name=name;
		this.goal=goal;
		this.balance=balance;
		this.startDate=startDate;
		this.endDate=endDate;
		this.videoUrl=videoUrl;
		this.categoryId=categoryId;
	}

	public String getName() {
		return name;
	}

	public void updateName(String name) {
		this.name = name;
	}

	public Long getGoal() {
		return goal;
	}

	public void updateGoal(Long goal) {
		this.goal = goal;
	}

	public Long getBalance() {
		return balance;
	}

	public void updateBalance(Long balance) {
		this.balance = balance;
	}

	public String getStartDate() {
		return startDate;
	}

	public void updateStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void updateEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void updateVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getcategoryId() {
		return categoryId;
	}

	public void updatecategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	
}
