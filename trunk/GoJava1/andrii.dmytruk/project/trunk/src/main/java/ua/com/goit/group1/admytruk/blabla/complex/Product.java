package ua.com.goit.group1.admytruk.blabla.complex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	
	@XmlAttribute
	private Integer id;
	
	@XmlAttribute(name = "name", required = true)	
	private String name;
	
	@XmlIDREF
	@XmlAttribute
	private Category category;
	
	public Product() {
	}
	
	protected Product(Integer idValue, String nameValue, Category categoryValue) {
		this.id = idValue;
		this.name = nameValue;
		this.category = categoryValue;
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
	

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {		
		return new StringBuffer()
			.append("id = ").append(getId())
			.append(", name = ").append(getName())
			.append(", category = [").append(getCategory()).append("]")
			.toString();
	}
	
}
