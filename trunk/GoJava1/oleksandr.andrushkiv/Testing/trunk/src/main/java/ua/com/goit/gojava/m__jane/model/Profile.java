package ua.com.goit.gojava.m__jane.model;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {
	
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	
	@XmlElement(name = "questionCategory")
	@XmlElementWrapper(name = "questionCategories")
	private List<Category> QuestionCategoryList;

	public Profile() {
	}	

	public Profile(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getQuestionCategoryList() {
		return QuestionCategoryList;
	}

	public void setQuestionCategoryList(List<Category> questionCategoryList) {
		QuestionCategoryList = questionCategoryList;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", "
				+ "name=" + name 
				+ ", QuestionCategories="	+ QuestionCategoryList + "]";
	}

	@Override
	public int hashCode() {		
		return Objects.hash(id, name);
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;		
		/*if (!Objects.equals(this, obj)) {
			return false;
		}*/		
		return true;
	}
	
}
