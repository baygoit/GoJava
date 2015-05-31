package kickstarter.repository.facade.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Quote implements Serializable {

	private static final long serialVersionUID = -7060451318379559888L;
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
