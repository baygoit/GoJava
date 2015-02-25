package ua.com.goit.gojava2.solo307.interview;

public class IdGenerator {
	
	private int questionId;
	private int answerId;
	
	public IdGenerator() {
		this.questionId = 0;
		this.answerId = 0;
	}
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public void addQuestionId(){
		questionId++;
	}
	
	public void addAsnwerId(){
		answerId++;
	}
}
