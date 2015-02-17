package kickstarter_gk;

public class FAQ {
	private String question;
	private String answer;
	private Project project; 
	
	public FAQ (String question, String answer, Project project) {
		this.question = question;
		this.answer = answer;
		this.project = project;
	}
	
	
	public String getQuestion () {
		return question;
	}
	
	public String getAnswer () {
		return answer;
	}
	
	public Project getProject () {
		return project;
	}
	
	
}



