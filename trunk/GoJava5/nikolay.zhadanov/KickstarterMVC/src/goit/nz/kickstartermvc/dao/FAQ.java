package goit.nz.kickstartermvc.dao;

public class FAQ {

	private String question;
	private String answer;

	public FAQ(String question) {
		this.question = question;
		answer = "";
	}

	public FAQ(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		if (answer.isEmpty()) {
			return "not yet answered...";
		}
		return answer;
	}

}
