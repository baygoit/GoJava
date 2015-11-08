package ua.com.sas.model;

public class Category {
	private String name;
	private int id;

	public Category(String name) {
		this.name = name;
	}
	
	public Category(int id) {
		this.id = id;
	}
	
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category name= " + name + ", id= " + id;
	}

	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setId(int id) {
		this.id = id;
	}
}
