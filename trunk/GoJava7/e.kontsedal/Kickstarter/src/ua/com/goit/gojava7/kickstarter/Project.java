package ua.com.goit.gojava7.kickstarter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Project {
	private String projectName;
	private String projectShortDescription;
	private String projectDescription;
	private String videoUrl;
	private HashMap<String, String> questionsAndAnswers;
	private int projectCostNeed;
	private int projectCostsCollected = 0;
	private Calendar deadline = new GregorianCalendar();

	public Project(String projectName, String projectShortDescription,
			int projectCostNeed, int projectDaysNeed) {
		this.projectName = projectName;
		this.questionsAndAnswers = new HashMap<>();
		this.projectShortDescription = projectShortDescription;
		this.projectCostNeed = projectCostNeed;
		deadline.add(Calendar.DAY_OF_YEAR, projectDaysNeed);
	}

	public String getProjectName() {
		return this.projectName;
	}

	public String getProjectShortDescription() {
		return this.projectShortDescription;
	}

	public int getProjectDaysLeft() {
		Calendar today = new GregorianCalendar();
		return (int) ((deadline.getTimeInMillis() - today.getTimeInMillis())
				/ 1000 / 60 / 60 / 24);// OLEG Magic number. Think about timezone
	}

	public int getProjectCostNeed() {
		return this.projectCostNeed;
	}
	public int getProjectCostCollected() {
		return this.projectCostsCollected;
	}
	public String getVideoUrl() {
		return this.videoUrl;
	}
	public HashMap<String, String> getQuestionsAndAnswer() {
		return this.questionsAndAnswers;
	}
	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectCostCollected(int price) {
		this.projectCostsCollected += price;
	}
	public void setVideoUrl(String url){
		this.videoUrl = url;
	}
	public void setQuestionsAndAnswer(String question, String answer){
		this.questionsAndAnswers.put(question, answer);
	}
	public void setProjectDescription(String description) {
		this.projectDescription = description;
	}

}
