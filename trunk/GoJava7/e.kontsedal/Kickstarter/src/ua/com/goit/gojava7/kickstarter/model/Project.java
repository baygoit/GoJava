package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class Project {
	private String projectName;
	private String projectShortDescription;
	private String projectDescription;
	private String videoUrl;
	private HashMap<String, String> questionsAndAnswers;
	private int projectCostNeed;
	private int projectCostsCollected;
	private Calendar deadline;
	private List<Payment> payments;
	private List<String> questions;

	public Project() {
		// default constructor
	}

	public Project(String projectName, String projectShortDescription, int projectCostNeed, int projectDaysNeed) {
		this.projectName = projectName;
		this.questionsAndAnswers = new HashMap<>();
		this.projectShortDescription = projectShortDescription;
		this.projectCostNeed = projectCostNeed;
		this.payments = new ArrayList<>();
		this.questions = new ArrayList<>();
		this.projectCostsCollected = 0;
		deadline = new GregorianCalendar();
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
				/ 1000 / 60 / 60 / 24);// OLEG
	}

	public int getProjectCostNeed() {
		return this.projectCostNeed;
	}

	public int getProjectCostCollected() {
		return this.projectCostsCollected;
	}

	public Calendar getDeadline() {
		return this.deadline;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public HashMap<String, String> getQuestionsAndAnswer() {
		return this.questionsAndAnswers;
	}

	public int getProjectCostsCollected() {
		return projectCostsCollected;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public String getProjectDescription() {
		return this.projectDescription;
	}
	
	public List<String> getQuestionList(){
		return this.questions;
	}

	public void setProjectCostCollected(int price) {
		this.projectCostsCollected += price;
	}

	public void setVideoUrl(String url) {
		this.videoUrl = url;
	}

	public void setQuestionsAndAnswer(String question, String answer) {
		this.questionsAndAnswers.put(question, answer);
	}

	public void setProjectDescription(String description) {
		this.projectDescription = description;
	}

	public void setDeadline(Calendar deadline) {
		this.deadline = deadline;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectShortDescription(String projectShortDescription) {
		this.projectShortDescription = projectShortDescription;
	}

	public void setProjectCostNeed(int projectCostNeed) {
		this.projectCostNeed = projectCostNeed;
	}

	public void setPayment(String cardOwner, long cardNumber, int rechargeAmount) {
		this.payments.add(new Payment(cardOwner, cardNumber, rechargeAmount));
		this.projectCostsCollected += rechargeAmount;
	}
	public void addQuestion(String question){
		this.questions.add(question);
	}

}
