package ua.com.goit.gojava7.kickstarter.domain;

import ua.com.goit.gojava7.kickstarter.storage.DonationStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuestionStorage;


public class Project{
	private String name;
    private String description;
    private Integer goal;
    private Integer pledged;
    private Integer daysToGo;
    private String history;
    private String link;
    private DonationStorage donationStorage = new DonationStorage();;
    private QuestionStorage questionStorage = new QuestionStorage();;    
 
	public Project() {}
    
    public Project(String name, String description, Integer goal, Integer pledged, 
    		Integer daysToGo, String history, String link){         
    	this.name = name;
    	this.description = description;
        this.goal = goal;
        this.pledged = pledged;
        this.daysToGo = daysToGo;
        this.history = history;
        this.link = link;          
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
    
    public void addToPledged(int amount) {
    	this.pledged += amount;
    }

	public DonationStorage getDonationStorage() {
		return donationStorage;
	}

	public void setDonationStorage(DonationStorage donationStorage) {
		this.donationStorage = donationStorage;
	}

	public QuestionStorage getQuestionStorage() {	
		return questionStorage;
	}

	public void setQuestionStorage(QuestionStorage questionStorage) {
		this.questionStorage = questionStorage;
	}

	public void addQuestion(Question question) {
		questionStorage.add(question);
	}

	
	String questionFile;
	public void setQuestionFile(String questionFile) {
		this.questionFile = questionFile;
	}
	
	public String getQuestionFile() {
		return questionFile;
	}

	public String getRewardFile() {
		return rewardFile;
	}

	String rewardFile;
	public void setRewardFile(String rewardFile) {
		this.rewardFile = rewardFile;
	}
        
}