package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.storage.Storage;

public class Project extends Storage<Question>{
	private String name;
    private String description;
    private Integer goal;
    private Integer pledged;
    private Integer daysToGo;
    private String history;
    private String link;
    private List<Question> questions = new ArrayList<Question>();
    
    public Project() {}
 
    public Project(String name, String description, Integer goal, Integer pledged, 
    		Integer daysToGo, String history, String link, List<Question> questions){         
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
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
	public Integer getGoal() {		
		return goal;
	}

    public void setGoal(Integer goal) {
    	this.goal = goal;
    }
    
    public Integer getPledged() {
    	return pledged;
    }
    
    public void setPledged(Integer pledged) {
    	this.pledged = pledged;
    }
      
    public Integer getDaysToGo() {
    	return daysToGo;
    }

    public void setDaysToGo(Integer daysToGo) {
    	this.daysToGo = daysToGo;
    }
    
    public String getHistory(){
    	return history;
    }

    public void setHistory(String history) {
    	this.history = history;
    }
    
    public String getLink(){
    	return link;
    }

    public void setLink(String link) {
    	this.link = link;
    }
    
    public List<Question> getQuestions(){
    	return getAll();
    }
    
    public void addQuestion(Question question) {
    	add(question);
    }
    
    public void addToPledged(int amount) {
    	this.pledged += amount;
    }
        
}