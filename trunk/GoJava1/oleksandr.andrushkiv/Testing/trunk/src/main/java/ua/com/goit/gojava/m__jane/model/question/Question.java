package ua.com.goit.gojava.m__jane.model.question;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import ua.com.goit.gojava.m__jane.model.answer.Answer;


//@XmlSeeAlso({Admin.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Question {
	
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	protected String content;
	
	//private Category category;
	
	//private Profile profile;
	/**
	 * if openQuestion==false then question has many variants of
	 * answers(a,b,c.... ), else only one (text the expected response)
	 */
	//private boolean openQuestion;

	public Question() {
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public abstract Answer createTemplateAnswer();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("Question [id=").append(id)
				.append(", content=").append(content)
				//.append(", questionCategory=").append(category.getName())
				//.append(", profile=").append(profile.getName())
				//.append(", openQuestion=").append(openQuestion)
				.append("]").toString();
	}
}
