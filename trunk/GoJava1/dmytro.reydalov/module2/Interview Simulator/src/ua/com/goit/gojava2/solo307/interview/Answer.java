package ua.com.goit.gojava2.solo307.interview;

public class Answer {
	
	public Answer(){
		answer = "answer";
		isAnswerRight = false;
	}
	
	public Answer(String answer, boolean isRight){
		this.answer = answer;
		this.isAnswerRight = isRight;
	}
	
	private String answer;
	boolean isAnswerRight;
	
	public String toString(){
		return answer + " - " + isAnswerRight;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isAnswerRight() {
		return isAnswerRight;
	}
	public void setAnswerRight(boolean isAnswerRight) {
		this.isAnswerRight = isAnswerRight;
	}
	
}
