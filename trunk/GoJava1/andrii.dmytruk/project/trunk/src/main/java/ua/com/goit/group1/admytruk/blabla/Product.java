package ua.com.goit.group1.admytruk.blabla;

public class Product {

	private int id;
	
	private String name;
	
	public Product() {
	}
	
	protected Product(int idValue, String nameValue) {
		this.id = idValue;
		this.name = nameValue;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
