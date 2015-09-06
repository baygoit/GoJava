package goit.nz.kickstarter.domain;

public class Category {

	private String name;
	private long id;

	public Category(long id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

}
