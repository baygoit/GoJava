package ua.com.goit.group1.admytruk.blabla.simple;

public class Product {
	
	private Integer id;
	
	private String name;
	
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
