package kickstarter.repository.facade.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category implements Serializable {

	private static final long serialVersionUID = 5586320940365035555L;
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
