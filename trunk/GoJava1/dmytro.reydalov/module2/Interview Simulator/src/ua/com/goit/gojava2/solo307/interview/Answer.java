package ua.com.goit.gojava2.solo307.interview;

public class Answer {
	
	private String answer;
	boolean isRight;
	int numberOfAnswer;
	
	public Answer(){
		answer = "here, must be The Answer...";
		isRight = false;
		numberOfAnswer = 0;
	}
	
	public Answer(String answer, boolean isRight, int numberOfAnswer){
		this.answer = answer;
		this.isRight = isRight;
		this.numberOfAnswer = numberOfAnswer;
	}
	
	public String toString(){
		return answer + " - " + isRight;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isAnswerRight() {
		return isRight;
	}
	public void setAnswerRight(boolean isAnswerRight) {
		this.isRight = isAnswerRight;
	}

	public int getNumberOfAnswer() {
		return numberOfAnswer;
	}

	public void setNumberOfAnswer(int numberOfAnswer) {
		this.numberOfAnswer = numberOfAnswer;
	}
	
	public void printNumberAndAnswer(){
		System.out.println(numberOfAnswer + ". " + answer + "\n");
	}
}
