package ua.com.goit.gojava.andriidnikitin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

	@XmlAttribute
	private Integer id;
	
	@XmlID
	@XmlAttribute
	private String name;
	
	public Category() {
	}

	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}
	
	public Integer getId() {
		return id;
	}

	public Category setId(Integer id) {
		this.id = id;
		return this;
	}	
	
	public String printInfo(){
		return "[" + id + "]  " + name ;
	}
}