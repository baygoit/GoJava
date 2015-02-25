package ua.com.goit.gojava2.solo307.interview;

public class Answer {
	
	int id;
	private String text;
	boolean isCorrect;
	boolean isChecked;
	
	public Answer(){
		text =  "there is an answer must be here...";
		isCorrect = false;
		id = 0;
	}

	public Answer(int id, String text, boolean isCorrect){
		this.text = text;
		this.isCorrect = isCorrect;
		this.id = id;
	}
	
	public int getId() {
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
	
	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public String getIdAndAnswer(){
		return new String(id + ". " + text + "\n");
	}

	public boolean hasNextId(int answeredId) {
		if(this.id == answeredId){
			return true;
		}
		return false;
	}

	public boolean isCorrectId() {
		if(isAnswerCorrect())return true;
		else{
			return false;
		}
	}
}
