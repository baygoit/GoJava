package ua.com.goit.gojava.solo307.intersim.domain;

public class Answer {

	private int questionId;
	int id;
	private String text;
	private boolean isCorrect;
	private boolean isChecked;

	public Answer() {
		text = "there is an answer must be here...";
		isCorrect = false;
	}

	public Answer(int id, String text, boolean isCorrect, int questionId) {
		this.text = text;
		this.isCorrect = isCorrect;
		this.id = id;
		this.questionId = questionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public void setId(int id) {
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
}
