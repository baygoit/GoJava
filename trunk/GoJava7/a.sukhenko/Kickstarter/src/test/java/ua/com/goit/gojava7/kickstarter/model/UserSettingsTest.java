package ua.com.goit.gojava7.kickstarter.model;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
public class UserSettingsTest {
	private UserSettings userSettings = new UserSettings();
	private Category category = new Category();
	private Project project = new Project();
	
	@Test
	public void testUserSettings() {
		assertNotNull(userSettings);
	}

	@Test
	public void testSetCategory() {
		userSettings.setCategory(category);
		assertThat(userSettings.getCategory(),is(category));
	}

	@Test
	public void testSetMenuOption() {
		userSettings.setMenuOption(MenuOptions.ADD_PAYMENT_SYSTEM_TO_ACCOUNT);
		assertThat(userSettings.getMenuOption(),is(MenuOptions.ADD_PAYMENT_SYSTEM_TO_ACCOUNT));
	}

	@Test
	public void testSetSelectedProject() {
		userSettings.setSelectedProject(project);
		assertThat(userSettings.getSelectedProject(),is(project));
	}

}
