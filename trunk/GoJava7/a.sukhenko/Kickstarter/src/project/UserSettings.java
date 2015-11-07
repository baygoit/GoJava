package project;

public class UserSettings {
	private Category category;
	public UserSettings(Category cat) {
		category = cat;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
