package ua.com.goit.gojava.solo307.intersim.domain;

public class Mark {

	private boolean isCorrect;
	private boolean isHalfcorrect;
	private boolean isIncorrect;

	public Mark() {
		isCorrect = false;
		isHalfcorrect = false;
		isIncorrect = false;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public boolean isHalfcorrect() {
		return isHalfcorrect;
	}

	public void setHalfcorrect(boolean isHalfcorrect) {
		this.isHalfcorrect = isHalfcorrect;
	}

	public boolean isIncorrect() {
		return isIncorrect;
	}

	public void setIncorrect(boolean isIncorrect) {
		this.isIncorrect = isIncorrect;
	}
}
