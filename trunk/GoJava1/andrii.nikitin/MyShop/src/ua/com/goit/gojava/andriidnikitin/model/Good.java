package ua.com.goit.gojava.andriidnikitin.model;

import java.math.BigDecimal;
import java.util.List;

public class Good {
	
	private Integer id;
	
	private String name;
	
	private GoodType type;
	
	private BigDecimal price;
	
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



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public List<Attribute> getDescription() {
		return description;
	}



	public void setDescription(List<Attribute> description) {
		this.description = description;
	}

	private class Attribute {
		
		private String name;
		
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
}

