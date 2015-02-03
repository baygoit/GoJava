package ua.com.goit.gojava.andriidnikitin.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ua.com.goit.gojava.andriidnikitin.service.BigDecimalAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Good {
	
	@XmlAttribute
	private Integer id;	

	@XmlAttribute
	private String name;
	
	@XmlIDREF
	@XmlAttribute
	private Category category;	
	
	@XmlJavaTypeAdapter(BigDecimalAdapter.class)
	@XmlAttribute
	private BigDecimal price;
	
	public BigDecimal getPrice() {
		return price;
	}

	public Good setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Good() {
	}	
	
	public Integer getId() {
		return id;
	}
	
	public Good setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public Good setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Category getCategory() {
		return category;
	}
	
	public Good setCategory(Category category) {
		this.category = category;
		return this;
	}
	
	public String printInfo(){
		return "[" + id + "]  " + name + " {" +  category.getName() + "}; " + price;
	}
}
