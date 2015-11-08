package ua.com.goit.gojava7.kickstarter.model;

/**
 * 
 * 
 */
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
