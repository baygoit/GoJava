package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;

public class Good {
	
	private Integer id;	

	private String name;
	
	private Category category;	
	
	private BigDecimal price;
	
	protected Good(Integer id, String name, Category category, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", category=" + category
				+ "]";
	}	
}
