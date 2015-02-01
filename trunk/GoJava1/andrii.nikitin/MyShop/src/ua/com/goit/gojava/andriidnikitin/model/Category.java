package ua.com.goit.gojava.andriidnikitin.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
	
	@XmlAttribute
	private Integer id;
	
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

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

		
}