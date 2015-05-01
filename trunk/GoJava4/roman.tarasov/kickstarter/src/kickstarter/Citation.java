package kickstarter;

public class Citation {
	int id;
	String text = "null";

	Citation(int id) {
		setId(id);
	}

	void setId(int id) {
		this.id = id;
	}

	int getId() {
		return id;
	}

	void setText(String text) {
		this.text = text;
	}

	String getText() {
		return text;
	}
}
