package kickstarter;

public class Category {
	String name="null";
	String description="null";
	int id;

	Category(int id) {
		setId(id);
	}

	void setDescription(String Description) {
		this.description = Description;
	}

	String getDescription() {
		return description;
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setId(int id) {
		this.id = id;
	}

	int getId() {
		return id;
	}

}
