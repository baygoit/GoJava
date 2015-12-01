package ua.com.goit.gojava7.kickstarter.model;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.User;
import ua.com.goit.gojava7.kickstarter.domain.user.UserSettings;
import ua.com.goit.gojava7.kickstarter.payment.PaymentSystem;

public class UserTest {
	User user = new User();
	UserSettings userSettings = new UserSettings();
	User user2 = new User(userSettings);
	@Test
	public void testUser() {
		assertNotNull(user);
	}

	@Test
	public void testUserUserSettings() {
		assertThat(user2.getSettings(),is(userSettings));
	}

	@Test
	public void testSetSettings() {
		user.setSettings(userSettings);
		assertThat(user.getSettings(),is(userSettings));
	}

	@Test
	public void testSetPaymentSystem() {
		PaymentSystem ps = new PaymentSystem();
		user.setPaymentSystem(ps);
		assertThat(user.getPaymentSystem(),is(ps));
	}

}
