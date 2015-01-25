package ua.com.goit.gojava.m__jane.model;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {
	
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	
	@XmlElement(name = "questionCategory")
	@XmlElementWrapper(name = "questionCategories")
	private List<QuestionCategory> QuestionCategories;

	public Profile() {
	}	

	public Profile(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<QuestionCategory> getQuestionCategories() {
		return QuestionCategories;
	}

	public void setQuestionCategories(List<QuestionCategory> questionCategories) {
		QuestionCategories = questionCategories;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + "]" + QuestionCategories;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id, name);
		
		/*final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;*/
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (id != other.id)
			return false;
	/*	if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;*/		
		if (!Objects.equals(name, other.name)) {
			return false;
		}		
		return true;
	}
	
}
