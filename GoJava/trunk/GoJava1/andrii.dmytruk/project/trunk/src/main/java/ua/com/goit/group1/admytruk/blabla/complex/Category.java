package ua.com.goit.group1.admytruk.blabla.complex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

	@XmlID
	@XmlAttribute
	@XmlJavaTypeAdapter(NumberIdentifierAdapter.class)
	private Integer id;
	
	@XmlAttribute(name = "name", required = true)
	private String name;
	
	public Category() {
	}
	
	protected Category(Integer idValue, String nameValue) {
		this.id = idValue;
		this.name = nameValue;
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
	
	@Override
	public String toString() {		
		return new StringBuffer()
			.append("id = ").append(getId())
			.append(", name = ").append(getName())
			.toString();
	}

}
