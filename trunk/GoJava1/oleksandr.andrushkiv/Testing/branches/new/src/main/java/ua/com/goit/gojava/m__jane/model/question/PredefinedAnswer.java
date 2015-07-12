package ua.com.goit.gojava.m__jane.model.question;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class PredefinedAnswer {

	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String content;

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

	@Override
	public String toString() {
		return "PredefinedAnswer [id=" + id + ", content=" + content + "]";
	}
	
	
}
