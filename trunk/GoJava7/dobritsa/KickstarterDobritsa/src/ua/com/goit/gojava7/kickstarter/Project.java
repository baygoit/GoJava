package ua.com.goit.gojava7.kickstarter;
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
 
    public Project(String name, String description, Integer goal, Integer pledged, Integer daysToGo, String history, String link, String questions){         
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
    
    //TODO
	// OLEG SRL violated
    public void printShort() {
    	System.out.println("Name: " + name);
    	System.out.println("Short description: " + description);
    	System.out.println("Goal: " + goal);
    	System.out.println("Pledged: " + pledged);
    	System.out.println("Days to go: " + daysToGo);    	
    }
    
    //TODO
	// OLEG SRL violated
    public void printFull() {
    	System.out.println("_________________________________________");  
    	System.out.println("\n0: for return to list of projects\n");    	
    	printShort();
    	System.out.println("History: " + history);
    	System.out.println("Link to the demo video: " + link);
    	System.out.println("Questions/Answers: " + questions);
    }
}