package ua.com.goit.gojava2.solo307.interview;

public class Answer {
	
	char id;
	private String text;
	boolean isCorrect;
	
	public Answer(){
		text =  "there is an answer must be here...";
		isCorrect = false;
		id = 0;
	}
	
	public Answer(char id, String text, boolean isCorrect){
		this.text = text;
		this.isCorrect = isCorrect;
		
		this.id = id;
	}
	
	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public boolean isAnswerCorrect() {
		return isCorrect;
	}
	
	public void setAnswerCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	public void printIdAndAnswer(){
		System.out.println(id + ". " + text + "\n");
	}
}
