package ua.com.goit.gojava2.solo307.interview;

public class Answer {
	
	private String answer;
	boolean isCorrect;
	int id;
	
	public Answer(){
		answer =  "there is an answer must be here...";
		isCorrect = false;
		id = 0;
	}
	
	public Answer(int numberOfAnswer, String answer, boolean isRight){
		this.answer = answer;
		this.isCorrect = isRight;
		this.id = numberOfAnswer;
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
		return id;
	}

	public void setNumberOfAnswer(int numberOfAnswer) {
		this.id = numberOfAnswer;
	}
	
	public void printNumberAndAnswer(){
		System.out.println(id + ". " + answer + "\n");
	}
}
