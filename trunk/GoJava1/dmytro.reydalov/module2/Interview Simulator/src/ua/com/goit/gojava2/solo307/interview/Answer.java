package ua.com.goit.gojava2.solo307.interview;

public class Answer {
	
	private String answer;
	boolean isCorrect;
	int numberOfAnswer;
	
	public Answer(){
		answer =  "there is an answer must be here...";
		isCorrect = false;
		numberOfAnswer = 0;
	}
	
	public Answer(String answer, boolean isRight, int numberOfAnswer){
		this.answer = answer;
		this.isCorrect = isRight;
		this.numberOfAnswer = numberOfAnswer;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public boolean isAnswerCorrect() {
		return isCorrect;
	}
	
	public void setAnswerCorrect(boolean isRight) {
		this.isCorrect = isRight;
	}

	public int getNumberOfAnswer() {
		return numberOfAnswer;
	}

	public void setNumberOfAnswer(int numberOfAnswer) {
		this.numberOfAnswer = numberOfAnswer;
	}
	
	public String toString(){
		return answer + " - " + isCorrect;
	}
	
	public void printNumberAndAnswer(){
		System.out.println(numberOfAnswer + ". " + answer + "\n");
	}
}
