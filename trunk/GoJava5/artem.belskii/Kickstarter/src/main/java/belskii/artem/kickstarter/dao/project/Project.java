package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="PROJECT")
public class Project {
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long projectId;
	private HashMap<Long, ArrayList<String>> faq;
	private HashMap<Long, HashMap<Long, String>> paymentVariants;
	private String name; 
	private Long goal;
	private Long balance; 
	private String startDate; 
	private String endDate;
	private String videoUrl; 
	private int categoryId;
	private String details;
	
	public Project(){}
	public Project(String name, Long goal, Long balance, String startDate, String endDate, String videoUrl, int categoryId, String details){
		faq = new HashMap<Long, ArrayList<String>>();
		paymentVariants = new HashMap<Long, HashMap<Long, String>>(); 
		this.name=name;
		this.goal=goal;
		this.balance=balance;
		this.startDate=startDate;
		this.endDate=endDate;
		this.videoUrl=videoUrl;
		this.categoryId=categoryId;
		this.details=details;
	}
	
	public Project(String name, Long goal, Long balance, String startDate, String endDate, String videoUrl, int categoryId, String details, HashMap<Long, ArrayList<String>> faq,  HashMap<Long, HashMap<Long, String>> paymentVariants ){
		this.faq=faq;
		this.paymentVariants=paymentVariants; 
		this.name=name;
		this.goal=goal;
		this.balance=balance;
		this.startDate=startDate;
		this.endDate=endDate;
		this.videoUrl=videoUrl;
		this.categoryId=categoryId;
		this.details=details;
	}


	public String getName() {
		return this.name;
	}

	public void updateName(String name) {
		this.name=name;
	}

	public Long getGoal() {
		return this.goal;
	}

	public void updateGoal(Long goal) {
		this.goal=goal;
	}

	public Long getBalance() {
		return this.balance;
	}

	public void updateBalance(Long balance) {
		this.balance+=balance;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void updateStartDate(String startDate) {
		this.startDate=startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void updateEndDate(String endDate) {
		this.endDate=endDate;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void updateVideoUrl(String videoUrl) {
		this.videoUrl=videoUrl;
	}

	public int getcategoryId() {
		return this.categoryId;
	}

	public void updatecategoryId(int categoryId) {
		this.categoryId=categoryId;
	}

	public String getDetails() {
		return this.details;
	}

	public void updateDetails(String details) {
		this.details=details;
	}

	public Long getProjectId() {
		return this.projectId;
	}
	
	public void setProjectId(long projectId) {
		this.projectId=projectId;
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
		this.faq.put(questionId, question);
	}
	
	public HashMap<Long, HashMap<Long, String>> getPaymetVariants() {
		return paymentVariants;
	}

	public void addPaymetVariants(Long value, String bonus) {
		HashMap<Long, String> paymetVariant = new HashMap<Long, String> (); 
		paymetVariant.put(value, bonus);
		Long index= new Long(this.paymentVariants.size());
		this.paymentVariants.put(index, paymetVariant);
	}

}
