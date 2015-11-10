package ua.com.goit.gojava7.kickstarter.domain;

public class Project {
	private String name;
	private Category categorie;
	private int funded;
	private int daysToGo;
	private int pledged; 
	private String description;
	private String owner;
	private int goal;
	private String linkVideo;
	
	public Project(String name, Category categorie) {
		
		setName(name);
		setCategorie(categorie);
		setFunded(0);
		setDaysToGo(40);
		setPledged(0);
		setDescription("");
		setOwner("");
		setGoal(0);
		setLinkVideo("");
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}
	
	public int getDaysToGo() {
		return daysToGo;
	}
	
	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getFunded() {
		return funded;
	}
	
	public void setFunded(int funded) {
		this.funded = funded;
	}
	
	public int getGoal() {
		return goal;
	}
	
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public String getLinkVideo() {
		return linkVideo;
	}
	
	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getPledged() {
		return pledged;
	}

	public void setPledged(int pledged) {
		this.pledged = pledged;
	}
	
	public Object[] getProject(int number){
		Object[] result = {number, name, funded, daysToGo, pledged};
				
		return result;
	}
	
	public String getAllDetails(){
		StringBuilder projectDetails = new StringBuilder();
		
		projectDetails.append("name: ").append(name).append("\n");
		projectDetails.append("categorie: ").append(categorie.getName()).append("\n");
		projectDetails.append("funded: ").append(funded).append("\n");
		projectDetails.append("daysToGo: ").append(daysToGo).append("\n");
		projectDetails.append("pledged: ").append(pledged).append("\n");
		projectDetails.append("description: ").append(description).append("\n");
		projectDetails.append("owner: ").append(owner).append("\n");
		projectDetails.append("goal: ").append(goal).append("\n");
		projectDetails.append("linkVideo: ").append(linkVideo);
		
		return projectDetails.toString();
	}
}
