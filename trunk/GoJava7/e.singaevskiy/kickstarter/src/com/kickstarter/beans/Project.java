package com.kickstarter.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

	private String name;
	private long goalSum;
	private long balanceSum;
	private Date startDate;
	private Date endDate;
	private List<Category> categories;
	private String description;
	private String videoUrl;
	private List<User> backers;
	private List<Reward> rewards;
	private List<FAQ> questionsAndAnswers;
	private User author;
	
	public Project() {
		categories = new ArrayList<>();
		questionsAndAnswers = new ArrayList<>();
		backers = new ArrayList<>();
		rewards = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getGoalSum() {
		return goalSum;
	}

	public void setGoalSum(Long goalSum) {
		this.goalSum = goalSum;
	}

	public Long getBalanceSum() {
		return balanceSum;
	}

	public void setBalanceSum(Long balanceSum) {
		this.balanceSum = balanceSum;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}

	public List<FAQ> getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

	public void setQuestionsAndAnswers(List<FAQ> questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}
	
	public void addQuestionAndAnswer(FAQ questionAndAnswer) {
		this.questionsAndAnswers.add(questionAndAnswer);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<User> getBackers() {
		return backers;
	}

	public void setBackers(List<User> backers) {
		this.backers = backers;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
	
	public long daysLeft() {
		long ms = getEndDate().getTime() - System.currentTimeMillis();
		return ms / (1000L*60L*60L*24L);
	}

	@Override
	public String toString() {
		return "Project \"" + name + "\" by " + author;
	}

    public static Builder newBuilder() {
        return new Project().new Builder();
    }
	
	public class Builder {

        private Builder() {}

        public Builder setAuthor(User author) {
            Project.this.author = author;   
            return this;
        }

        public Builder setDescription(String description) {
        	Project.this.description = description; 
            return this;
        }
        
        public Builder setStartDate(Date startDate) {
        	Project.this.startDate = startDate; 
            return this;
        }
        
        public Builder setEndDate(Date endDate) {
        	Project.this.endDate = endDate; 
            return this;
        }
        
        public Builder setGoalSum(Long goalSum) {
        	Project.this.goalSum = goalSum; 
            return this;
        }
        
        public Builder setBalanceSum(Long balanceSum) {
        	Project.this.balanceSum = balanceSum; 
            return this;
        }
        
        public Builder setVideoURL(String videoUrl) {
        	Project.this.videoUrl = videoUrl; 
            return this;
        }
        
        public Builder setName(String name) {
        	Project.this.name = name; 
            return this;
        }
        
        public Builder addCategory(Category category) {
        	Project.this.addCategory(category); 
            return this;
        }
        
        public Builder addFAQ(FAQ faq) {
        	Project.this.questionsAndAnswers.add(faq); 
            return this;
        }
        
        public Project build() {
            return Project.this;
        }

    }
	
}
