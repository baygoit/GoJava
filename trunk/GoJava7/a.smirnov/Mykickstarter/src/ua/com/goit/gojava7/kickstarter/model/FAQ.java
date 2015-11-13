package ua.com.goit.gojava7.kickstarter.model;

public class FAQ implements Comparable<FAQ>{
	private String question;
	private String answer;
	
	public FAQ(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int compareTo(FAQ that) {
		return this.question.compareTo(that.getQuestion());
	}
}
