package ua.com.scread.kickstarter.data;

public class FAQ {
	private String question;
	private String answer;

	public FAQ(String question, String answer) {
		this.question = question;
		if (answer == "") {
		    this.answer = "There is no answer yet.";
		} else {
		    this.answer = answer;		    
		}
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
	    this.answer = answer;
	}
    
    @Override
    public String toString() {
        return question + ";" + answer + ";";
    }

}
