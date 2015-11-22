package ua.com.goit.gojava7.kickstarter.domain;

public class Project {
	private String name;
	private String summary;
	private String info;
	private long goal;
	private long pledged;
	private int daysToGo;
	private String history;
	private String video;
	private String questionsAndAnswers;
	
	public Project(String name, String summary, long goal) {
		this.name = name;
		this.summary = summary;
		this.goal = goal;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public long getGoal() {
		return goal;
	}

	public long getPledged() {
		return pledged;
	}
	
	public void setPledged(long pledged) {
		this.pledged = pledged;
	}

	public int getDaysToGo() {
		return daysToGo;
	}
	
	public String getHistory() {
		return history;
	}
	
	public void setHistory(String history) {
		this.history = history;
	}
	
	public String getVideo() {
		return video;
	}
	
	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}
	
	public void setQuestionsAndAnswers(String questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}
}
