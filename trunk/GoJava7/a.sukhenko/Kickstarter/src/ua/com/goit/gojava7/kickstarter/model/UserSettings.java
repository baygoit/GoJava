package ua.com.goit.gojava7.kickstarter.model;

/**
 * 
 * 
 */
public class UserSettings {
	private Category category;
	private Project selectedProject;
	private MENU_OPTIONS menuOption = MENU_OPTIONS.SHOW_MAIN_MENU;
	public UserSettings() {
		// TODO Auto-generated constructor stub
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MENU_OPTIONS getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(MENU_OPTIONS menuOption) {
		this.menuOption = menuOption;
	}

	public Project getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
}
