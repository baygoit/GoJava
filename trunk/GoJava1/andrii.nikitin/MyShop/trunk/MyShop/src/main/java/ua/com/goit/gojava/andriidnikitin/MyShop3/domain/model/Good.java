package ua.com.goit.gojava.andriidnikitin.MyShop3.domain.model;

public class Good {
	
	private Integer id;
	
	private String name;
	
	private GoodType type;

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
	
}

