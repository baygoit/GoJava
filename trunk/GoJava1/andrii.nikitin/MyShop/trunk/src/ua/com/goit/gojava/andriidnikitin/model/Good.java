package ua.com.goit.gojava.andriidnikitin.model;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.util.Attribute;

public class Good {
	
	private Integer id;
	
	private String name;
	
	private GoodType type;
	
	private List<Attribute> description;	

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

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}


	public List<Attribute> getDescription() {
		return description;
	}

	public void setDescription(List<Attribute> description) {
		this.description = description;
	}

}

