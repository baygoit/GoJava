package ua.com.goit.gojava.m__jane.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rootElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataLoader {
	
	@XmlElement(name = "profile")
	@XmlElementWrapper(name = "profiles")
	private List<Profile> profileList;

	public List<Profile> getProfileList() {
		if (profileList == null) {
			profileList = new ArrayList<Profile>();
		}
		return profileList;
	}


}
