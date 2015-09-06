package goit.nz.kickstarter.domain;

public class FAQ {
	private String question;
	private String answer;

	public FAQ(String question, String answer) {
		this.question = question;
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
