package kickstarter.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quote  {

	private String quote;
	private int ID;

	public int getID() {
		return ID;
	}
	@XmlElement
	public void setQuote(String quote) {
		this.quote = quote;
	}
	@XmlAttribute
	public void setID(int iD) {
		ID = iD;
	}

	public String getQuote() {
		return quote;
	}
}
