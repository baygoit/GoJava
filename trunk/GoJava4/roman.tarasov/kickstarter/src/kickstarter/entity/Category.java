package kickstarter.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category  {
	private String name;
	private int ID;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}

	@XmlAttribute
	public void setID(int iD) {
		ID = iD;
	}
}
