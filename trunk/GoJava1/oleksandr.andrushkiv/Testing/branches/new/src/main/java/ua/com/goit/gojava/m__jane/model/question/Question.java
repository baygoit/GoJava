package ua.com.goit.gojava.m__jane.model.question;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.utils.IDAdapter;


@XmlSeeAlso({MultipleQuestion.class, SimpleQuestion.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Question {
	
	@XmlID
	@XmlAttribute
	@XmlJavaTypeAdapter(IDAdapter.class)
	private Integer id;
	
	@XmlAttribute
	protected String content;
	
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
	
}
