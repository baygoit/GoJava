package kickstarter;

public class Category {
	
	private String name;
	private int index;

	public Category(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	public String toString(){
		return (index + ". " + name);
	}

}
