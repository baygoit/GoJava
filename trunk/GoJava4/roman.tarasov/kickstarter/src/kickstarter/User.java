package kickstarter;

public class User {
	int id;
	String name = "anonymous";

	User(int id) {
		setId(id);
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
