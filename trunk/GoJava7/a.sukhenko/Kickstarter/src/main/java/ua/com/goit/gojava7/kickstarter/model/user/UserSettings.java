package ua.com.goit.gojava7.kickstarter.model.user;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.MenuOptions;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class UserSettings {
	private Category category;
	private Project selectedProject;
	private MenuOptions menuOption = MenuOptions.SHOW_MAIN_MENU;

	public UserSettings() {
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MenuOptions getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(MenuOptions menuOption) {
		this.menuOption = menuOption;
	}

	public Project getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
}
