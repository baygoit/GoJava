package education.kickstarter.spring.ioc.model;


public class Quote  {

	private String quote;
	private int ID;

	public int getID() {
		return ID;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public void setID(int iD) {
		ID = iD;
	}

	public String getQuote() {
		return quote;
	}
}
