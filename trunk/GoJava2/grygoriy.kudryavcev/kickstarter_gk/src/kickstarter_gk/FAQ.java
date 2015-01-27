package kickstarter_gk;

public class FAQ {
	private String qst;
	private String answr;
	
	public FAQ (String qst, String answr) {
		this.qst = qst;
		this.answr = answr;
	}
	
	
	public String getQuestion () {
		return qst;
	}
	
	public String getAnswer () {
		return answr;
	}
}



