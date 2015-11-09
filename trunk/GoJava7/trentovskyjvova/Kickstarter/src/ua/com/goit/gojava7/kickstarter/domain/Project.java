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
	
	public Project(String name, Category categorie, int funded, int daysToGo,
			int pledged, String description, String owner, int goal,
			String linkVideo) {
		
		this.name = name;
		this.categorie = categorie;
		this.funded = funded;
		this.daysToGo = daysToGo;
		this.pledged = pledged;
		this.description = description;
		this.owner = owner;
		this.goal = goal;
		this.linkVideo = linkVideo;
	}

	public String getName() {
		return name;
	}
	
	public Category getCategorie() {
		return categorie;
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
