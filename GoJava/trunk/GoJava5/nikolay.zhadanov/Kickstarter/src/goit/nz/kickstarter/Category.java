package goit.nz.kickstarter;

public class Category {
	private String name;
	private CategoryList list;
	
	public Category(String name, CategoryList list) {
		this.name = name;
		this.list = list;
		this.list.add(this);
	}
	
	public String getName() {
		return name;
	}
}
