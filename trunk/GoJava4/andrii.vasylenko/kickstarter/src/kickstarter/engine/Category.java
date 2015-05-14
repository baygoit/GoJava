package kickstarter.engine;

public class Category implements Data {
	private static int count = 0;
	
	private int id;
	private String name;

	public Category(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.id = ++count;
		this.name = name;
	}
	
	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
