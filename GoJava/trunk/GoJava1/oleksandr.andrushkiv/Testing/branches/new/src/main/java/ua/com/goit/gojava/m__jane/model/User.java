package ua.com.goit.gojava.m__jane.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlIDREF;
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String login;
	@XmlAttribute
	private String password;
	
	@XmlIDREF
	@XmlElement(name = "profile")
	@XmlElementWrapper(name = "profiles")
	private List<Profile> profileList;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Profile> getProfileList() {
		return profileList;
	}

	public void setProfileList(List<Profile> profileList) {
		this.profileList = profileList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + login + "]";
	}
		
}
