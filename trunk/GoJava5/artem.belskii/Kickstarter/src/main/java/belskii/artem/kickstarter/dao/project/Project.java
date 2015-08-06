package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;
import java.util.HashMap;


public class Project {
	private HashMap<String, Object> project ;
	private HashMap<Long, ArrayList<String>> faq;
	
	public Project(String name, Long goal, Long balance, String startDate, String endDate, String videoUrl, int categoryId, String details){
		project = new HashMap<String, Object>();
		faq = new HashMap<Long, ArrayList<String>>();
		project.put("NAME", name);
		project.put("GOAL", goal);
		project.put("BALANCE", balance);
		project.put("START_DATE", startDate);
		project.put("END_DATE", endDate);
		project.put("VIDEO_URL", videoUrl);
		project.put("CATEGORY_ID", categoryId);
		project.put("DETAILS", details);
		project.put("PROJECT_ID","NaN");
		//this.paymentVariants.putAll(paymetVariants);
	}

	public String getName() {
		return project.get("NAME").toString();
	}

	public void updateName(String name) {
		project.replace("NAME", name);
	}

	public Long getGoal() {
		return (Long) project.get("GOAL");
	}

	public void updateGoal(Long goal) {
		project.replace("GOAL", goal);
	}

	public Long getBalance() {
		return (Long) project.get("BALANCE");
	}

	public void updateBalance(Long balance) {
		Long currentBalance = this.getBalance(); 
		project.replace("BALANCE", currentBalance+balance);
	}

	public String getStartDate() {
		return project.get("START_DATE").toString();
	}

	public void updateStartDate(String startDate) {
		project.replace("START_DATE", startDate);
	}

	public String getEndDate() {
		return project.get("END_DATE").toString();
	}

	public void updateEndDate(String endDate) {
		project.replace("END_DATE", endDate);
	}

	public String getVideoUrl() {
		return project.get("VIDEO_URL").toString();
	}

	public void updateVideoUrl(String videoUrl) {
		project.replace("VIDEO_URL", videoUrl);
	}

	public int getcategoryId() {
		return (Integer) project.get("CATEGORY_ID");
		
	}

	public void updatecategoryId(int categoryId) {
		project.replace("CATEGORY_ID", categoryId);
	}

	public String getDetails() {
		return project.get("DETAILS").toString();
	}

	public void updateDetails(String details) {
		project.replace("DETAILS", details);
	}

	public Long getProjectId() {
		return (Long) project.get("PROJECT_ID");
	}
	
	public void setProjectId(long projectId) {
		project.replace("PROJECT_ID", projectId);
	}

	public HashMap<Long, ArrayList<String>> getFaq(){
		return this.faq;
	}
	
	public void asqAQuestion(String question){
		Long index = new Long(this.faq.size());
		ArrayList<String> newQuestion = new ArrayList<String>();
		newQuestion.add(question);
		newQuestion.add("not answered yet");		
		this.faq.put(index, newQuestion);
	}
	
	public void getAnswerForQuestion(Long questionId, String answer){
		ArrayList<String> question =  this.faq.get(questionId);
		question.set(1, answer);
		this.faq.replace(questionId, question);
	}
	
	/*
	public HashMap<Long, String> getPaymetVariants() {
		return paymentVariants;
	}

	public void updatePaymetVariants(HashMap<Long, String> paymetVariants) {
		this.paymentVariants.putAll(paymetVariants);
	}
*/
}
