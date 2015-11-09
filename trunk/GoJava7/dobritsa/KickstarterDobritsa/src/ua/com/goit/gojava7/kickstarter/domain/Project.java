package ua.com.goit.gojava7.kickstarter.domain;
public class Project{
	private String name;
    private String description;
    private Integer goal;
    private Integer pledged;
    private Integer daysToGo;
    private String history;
    private String link;
    private String questions;
    
    public Project() {}
 
    public Project(String name, String description, Integer goal, Integer pledged, 
    		Integer daysToGo, String history, String link, String questions){         
    	this.name = name;
    	this.description = description;
        this.goal = goal;
        this.pledged = pledged;
        this.daysToGo = daysToGo;
        this.history = history;
        this.link = link;
        this.questions = questions;
    }    

    public String getName() {
    	return name;
    }
    
    public String getDescription() {
    	return description;
    }
    
	public Integer getGoal() {		
		return goal;
	}
    
    public Integer getAmount() {
    	return goal;
    }
    
    public Integer getPledged() {
    	return pledged;
    }
    
    public Integer getDaysToGo() {
    	return daysToGo;
    }
    
    public String getHistory(){
    	return history;
    }
    
    public String getLink(){
    	return link;
    }
    
    public String getQuestions(){
    	return questions;
    }    
}