package ua.com.goit.group1.admytruk.blabla.simple;

public class Category {

	private Integer id;
	
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
