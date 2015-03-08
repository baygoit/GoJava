package com.gojava2.kickstarter.model;

public class Category {
	
	private String name;
	
	public Category(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return (name == null) ? 0 : name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;			
		} if (obj == null) {
			return false;			
		} if (getClass() != obj.getClass()) {
			return false;
		}
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}